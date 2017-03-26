package de.rgra.vet.pet.spi;

import java.util.ArrayList;
import java.util.List;

import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.spi.CustomerViewTabService;
import de.rgra.vet.customer.ui.CustomerView;
import de.rgra.vet.pet.db.PetDao;
import de.rgra.vet.pet.model.Pet;
import de.rgra.vet.pet.nl.Messages;
import de.rgra.vet.pet.ui.PetTable;
import de.rgra.vet.pet.ui.PetView;
import javafx.scene.Node;
import javafx.scene.control.Tab;

public class PetCustomerViewTabService implements CustomerViewTabService {

	@Override
	public List<Tab> createTabs(CustomerView view, Customer customer) {
		List<Tab> tabs = new ArrayList<>();
		tabs.add(createTab(Messages.getString("CustomerView.pets"), createPetNode(view, customer))); //$NON-NLS-1$
		return tabs;
	}

	private Node createPetNode(CustomerView view, Customer customer) {
		List<Pet> pets = new PetDao().fetchPetsForCustomer(customer.getId());
		PetTable table = new PetTable(pets, false) {
			@Override
			protected void onDoubleClick(Pet pet) {
				view.replace(new PetView(customer, pet));
			}
		};
		return table;
	}

	// ######
	private Tab createTab(String name, Node node) {
		Tab tab = new Tab();
		tab.setText(name);
		tab.setContent(node);
		return tab;
	}

}
