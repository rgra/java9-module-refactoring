package de.rgra.car.ui;

import java.time.LocalDate;
import java.util.List;

import de.rgra.car.model.Car;
import de.rgra.car.nl.Messages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;

public class CarTable extends VBox {

	@SuppressWarnings("unchecked")
	public CarTable(List<Car> cars, boolean showCustomer) {
		final ObservableList<Car> data = FXCollections.observableArrayList(cars);

		TableView<Car> table = new TableView<>();
		table.setEditable(false);
		table.setRowFactory(tv -> {
			TableRow<Car> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && !row.isEmpty()) {
					Car rowData = row.getItem();
					onDoubleClick(rowData);
				}
			});
			return row;
		});

		TableColumn<Car, String> nameCol = new TableColumn<>(Messages.getString("CarTable.name")); //$NON-NLS-1$
		nameCol.setCellValueFactory(new PropertyValueFactory<Car, String>("name")); //$NON-NLS-1$

		TableColumn<Car, String> typeCol = new TableColumn<>(Messages.getString("CarTable.type")); //$NON-NLS-1$
		typeCol.setCellValueFactory(new PropertyValueFactory<Car, String>("type")); //$NON-NLS-1$

		TableColumn<Car, String> yearCol = new TableColumn<>(Messages.getString("CarTable.year")); //$NON-NLS-1$
		yearCol.setCellValueFactory(new PropertyValueFactory<Car, String>("year")); //$NON-NLS-1$

		TableColumn<Car, String> colorCol = new TableColumn<>(Messages.getString("CarTable.color")); //$NON-NLS-1$
		colorCol.setCellValueFactory(new PropertyValueFactory<Car, String>("color")); //$NON-NLS-1$

		TableColumn<Car, LocalDate> lastVisitCol = new TableColumn<>(Messages.getString("CarTable.lastVisit")); //$NON-NLS-1$
		lastVisitCol.setCellValueFactory(new PropertyValueFactory<Car, LocalDate>("lastVisit")); //$NON-NLS-1$
		Callback<TableColumn<Car, LocalDate>, TableCell<Car, LocalDate>> defaultCellFactory = TextFieldTableCell
				.forTableColumn(new LocalDateStringConverter());
		lastVisitCol.setCellFactory(tc -> {
			TableCell<Car, LocalDate> cell = defaultCellFactory.call(tc);
			cell.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$
			return cell;
		});

		TableColumn<Car, String> customerCol = new TableColumn<>(Messages.getString("CarTable.customerId")); //$NON-NLS-1$
		customerCol.setCellValueFactory(new PropertyValueFactory<Car, String>("customerId")); //$NON-NLS-1$
		customerCol.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$

		table.getColumns().addAll(nameCol, typeCol, yearCol, colorCol, lastVisitCol);
		if (showCustomer) {
			table.getColumns().add(customerCol);
		}

		table.setItems(data);

		this.setSpacing(5);
		this.setPadding(new Insets(10, 0, 0, 10));
		this.getChildren().addAll(table);
	}

	protected void onDoubleClick(Car rowData) {
		// nichts
	}
}
