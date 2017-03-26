package de.rgra.vet.pet.ui;

import java.util.List;

import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.ui.CustomerInfoPane;
import de.rgra.vet.pet.model.Pet;
import de.rgra.vet.pet.nl.Messages;
import de.rgra.vet.visit.db.VisitDao;
import de.rgra.vet.visit.model.Visit;
import de.rgra.vet.visit.ui.VisitTable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PetView extends BorderPane {

	private final Customer customer;
	private Pet pet;

	public PetView(Customer customer, Pet pet) {
		this.customer = customer;
		this.pet = pet;
		setTop(createHead());
		setCenter(createTabPane());
	}

	private Node createHead() {
		GridPane group = new GridPane();
		group.setHgap(10);
		group.setVgap(5);
		int row = 0;

		group.add(new Label(Messages.getString("PetView.name")), 0, row); //$NON-NLS-1$
		TextField nameText = new TextField();
		nameText.textProperty().bindBidirectional(pet.getNameProperty());
		group.add(nameText, 1, row++);
		
		group.add(new Label(Messages.getString("PetView.race")), 0, row); //$NON-NLS-1$
		TextField raceText = new TextField();
		raceText.textProperty().bindBidirectional(pet.getRaceProperty());
		group.add(raceText, 1, row++);

		return new HBox(20, group, new CustomerInfoPane(customer));
	}

	private Node createTabPane() {
		TabPane tabPane = new TabPane();

		Tab tab = createTab(Messages.getString("PetView.visits"), createVisitNode()); //$NON-NLS-1$

		tabPane.getTabs().add(tab);
		return tabPane;
	}

	private Node createVisitNode() {
		List<Visit> visits = new VisitDao().getVisitsByPetId(pet.getId());
		return new VisitTable(visits, false);
	}

	// ######
	private Tab createTab(String name, Node node) {
		Tab tab = new Tab();
		tab.setText(name);
		tab.setContent(node);
		return tab;
	}

	

}
