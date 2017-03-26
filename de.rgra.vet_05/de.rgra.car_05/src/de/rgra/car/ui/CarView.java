package de.rgra.car.ui;

import java.text.NumberFormat;
import java.util.List;

import de.rgra.car.model.Car;
import de.rgra.car.nl.Messages;
import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.ui.CustomerInfoPane;
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

public class CarView extends BorderPane {

	private final Customer customer;
	private Car car;

	public CarView(Customer customer, Car car) {
		this.customer = customer;
		this.car = car;
		setTop(createHead());
		setCenter(createTabPane());
	}

	private Node createHead() {
		GridPane group = new GridPane();
		group.setHgap(10);
		group.setVgap(5);
		int row = 0;

		group.add(new Label(Messages.getString("CarView.name")), 0, row); //$NON-NLS-1$
		TextField nameText = new TextField();
		nameText.textProperty().bindBidirectional(car.getNameProperty());
		group.add(nameText, 1, row++);

		group.add(new Label(Messages.getString("CarView.type")), 0, row); //$NON-NLS-1$
		TextField raceText = new TextField();
		raceText.textProperty().bindBidirectional(car.getTypeProperty());
		group.add(raceText, 1, row++);

		group.add(new Label(Messages.getString("CarView.year")), 0, row); //$NON-NLS-1$
		TextField yearText = new TextField();
		yearText.textProperty().bindBidirectional(car.getYearProperty(), NumberFormat.getNumberInstance());
		group.add(yearText, 1, row++);

		group.add(new Label(Messages.getString("CarView.color")), 0, row); //$NON-NLS-1$
		TextField colorText = new TextField();
		colorText.textProperty().bindBidirectional(car.getColorProperty());
		group.add(colorText, 1, row++);

		return new HBox(20, group, new CustomerInfoPane(customer));
	}

	private Node createTabPane() {
		TabPane tabPane = new TabPane();

		Tab tab = createTab(Messages.getString("CarView.visits"), createVisitNode()); //$NON-NLS-1$

		tabPane.getTabs().add(tab);
		return tabPane;
	}

	private Node createVisitNode() {
		List<Visit> visits = new VisitDao().getVisitsByForeignId(car.getId());
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
