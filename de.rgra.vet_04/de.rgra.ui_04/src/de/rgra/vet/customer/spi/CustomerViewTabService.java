package de.rgra.vet.customer.spi;

import java.util.List;

import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.ui.CustomerView;
import javafx.scene.control.Tab;

public interface CustomerViewTabService {
	public List<Tab> createTabs(CustomerView view, Customer customer);
}
