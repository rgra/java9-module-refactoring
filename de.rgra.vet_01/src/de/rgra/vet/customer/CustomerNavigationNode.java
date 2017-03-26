package de.rgra.vet.customer;

import de.rgra.vet.NavigationNode;
import de.rgra.vet.customer.Customer;
import javafx.scene.Node;

public class CustomerNavigationNode extends NavigationNode {

	private final Customer customer;

	public CustomerNavigationNode(Customer customer) {
		super(String.format("%1$03d", customer.getId()) + " - " + customer.getName()); //$NON-NLS-1$ //$NON-NLS-2$
		this.customer = customer;
	}

	@Override
	public Node createNode() {
		return new CustomerView(customer);
	}

}
