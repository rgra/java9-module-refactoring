package de.rgra.vet.customer;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class CustomerTable extends VBox {

	@SuppressWarnings("unchecked")
	public CustomerTable(List<Customer> customers) {
		final ObservableList<Customer> data = FXCollections.observableArrayList(customers);

		TableView<Customer> table = new TableView<>();
		table.setEditable(false);

		TableColumn<Customer, String> nameCol = new TableColumn<>(Messages.getString("CustomerTable.name")); //$NON-NLS-1$
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name")); //$NON-NLS-1$

		TableColumn<Customer, String> raceCol = new TableColumn<>(Messages.getString("CustomerTable.street")); //$NON-NLS-1$
		raceCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("street")); //$NON-NLS-1$

		table.getColumns().addAll(nameCol, raceCol);

		table.setItems(data);

		this.setSpacing(5);
		this.setPadding(new Insets(10, 0, 0, 10));
		this.getChildren().addAll(table);
	}
}
