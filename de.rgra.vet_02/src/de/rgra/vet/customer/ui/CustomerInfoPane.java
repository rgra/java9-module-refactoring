package de.rgra.vet.customer.ui;

import java.text.NumberFormat;

import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.nl.Messages;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CustomerInfoPane extends HBox {

	public CustomerInfoPane(Customer customer) {
		super(20, createGroup(customer), createAddress(customer));
	}

	private static GridPane createGroup(Customer customer) {
		GridPane group = new GridPane();
		group.setHgap(10);
		group.setVgap(5);
		int row = 0;

		group.add(new Label(Messages.getString("CustomerInfoPane.customerId")), 0, row); //$NON-NLS-1$
		TextField customerIdText = new TextField();
		customerIdText.textProperty().bindBidirectional(customer.getIdProperty(), NumberFormat.getNumberInstance());
		group.add(customerIdText, 1, row++);

		group.add(new Label(Messages.getString("CustomerInfoPane.name")), 0, row); //$NON-NLS-1$
		TextField nameText = new TextField();
		nameText.textProperty().bindBidirectional(customer.getNameProperty());
		group.add(nameText, 1, row++);
		return group;
	}

	private static Node createAddress(Customer customer) {
		GridPane adress = new GridPane();
		adress.setHgap(10);
		adress.setVgap(5);
		int row = 0;

		adress.add(new Label(Messages.getString("CustomerInfoPane.street")), 0, row); //$NON-NLS-1$
		TextField streetText = new TextField();
		streetText.textProperty().bindBidirectional(customer.getStreetProperty());
		adress.add(streetText, 1, row++);

		adress.add(new Label(Messages.getString("CustomerInfoPane.zipcode")), 0, row); //$NON-NLS-1$
		TextField zipCodeText = new TextField();
		zipCodeText.textProperty().bindBidirectional(customer.getZipcodeProperty());
		adress.add(zipCodeText, 1, row++);

		adress.add(new Label(Messages.getString("CustomerInfoPane.city")), 0, row); //$NON-NLS-1$
		TextField cityText = new TextField();
		cityText.textProperty().bindBidirectional(customer.getCityProperty());
		adress.add(cityText, 1, row++);

		return adress;
	}
}