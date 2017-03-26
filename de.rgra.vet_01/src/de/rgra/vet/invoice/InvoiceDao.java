package de.rgra.vet.invoice;

import static de.rgra.vet.RandomUtils.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import de.rgra.vet.customer.Customer;
import de.rgra.vet.customer.CustomerDao;

public class InvoiceDao {

	private static final List<Invoice> invoices = createInvoices();

	public List<Invoice> fetchInvoicesForCustomer(int customerId) {
		return invoices.stream().filter(invoice -> invoice.getCustomerId() == customerId)
				.sorted(comparing(Invoice::getDate).reversed())
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private static List<Invoice> createInvoices() {
		List<Invoice> result = new ArrayList<>();

		for (Customer customer : new CustomerDao().fetchCustomers()) {
			result.addAll(createInvoices(customer.getId()));
		}
		AtomicInteger id = new AtomicInteger(1);
		result.forEach(invoice -> invoice.setId(id.getAndIncrement()));

		return Collections.unmodifiableList(result);
	}

	private static List<Invoice> createInvoices(int customerId) {
		List<Invoice> result = new ArrayList<>();

		for (int i = 0; i < randomInt(3) + 1; i++) {
			Invoice invoice = new Invoice();
			invoice.setCustomerId(customerId);
			invoice.setDate(randomDate());
			invoice.setTotal(new BigDecimal(randomInt(10_000) + 1_000));
			invoice.setPayed(randomBoolean());
			result.add(invoice);
		}

		return result;
	}
}
