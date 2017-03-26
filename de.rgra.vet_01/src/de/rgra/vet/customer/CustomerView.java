package de.rgra.vet.customer;

import java.util.List;

import de.rgra.vet.invoice.Invoice;
import de.rgra.vet.invoice.InvoiceDao;
import de.rgra.vet.invoice.InvoiceTable;
import de.rgra.vet.pet.Pet;
import de.rgra.vet.pet.PetDao;
import de.rgra.vet.pet.PetTable;
import de.rgra.vet.pet.PetView;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class CustomerView extends BorderPane {

	private final Customer customer;

	public CustomerView(Customer customer) {
		this.customer = customer;
		setTop(new CustomerInfoPane(customer));
		setCenter(createTabPane());
	}

	private Node createTabPane() {
		TabPane tabPane = new TabPane();
		tabPane.getTabs().add(createTab(Messages.getString("CustomerView.pets"), createPetNode())); //$NON-NLS-1$
		tabPane.getTabs().add(createTab(Messages.getString("CustomerView.invoices"), createInvoiceNode())); //$NON-NLS-1$
		return tabPane;
	}

	private Node createInvoiceNode() {
		List<Invoice> invoices = new InvoiceDao().fetchInvoicesForCustomer(customer.getId());
		InvoiceTable table = new InvoiceTable(invoices);
		return table;
	}

	private Node createPetNode() {
		List<Pet> pets = new PetDao().fetchPetsForCustomer(customer.getId());
		PetTable table = new PetTable(pets, false) {
			@Override
			protected void onDoubleClick(Pet pet) {
				replace(new PetView(customer, pet));
			}
		};
		return table;
	}
	
	public void replace(BorderPane newView) {
		BorderPane parent = (BorderPane) this.getParent();
		parent.setCenter(newView);
	}

	// ######
	private Tab createTab(String name, Node node) {
		Tab tab = new Tab();
		tab.setText(name);
		tab.setContent(node);
		return tab;
	}

}
