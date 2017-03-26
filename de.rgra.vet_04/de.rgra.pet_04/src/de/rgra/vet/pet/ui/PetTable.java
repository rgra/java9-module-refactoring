package de.rgra.vet.pet.ui;

import java.time.LocalDate;
import java.util.List;

import de.rgra.vet.pet.model.Pet;
import de.rgra.vet.pet.nl.Messages;
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

public class PetTable extends VBox {

	@SuppressWarnings("unchecked")
	public PetTable(List<Pet> pets, boolean showCustomer) {
		final ObservableList<Pet> data = FXCollections.observableArrayList(pets);

		TableView<Pet> table = new TableView<>();
		table.setEditable(false);
		table.setRowFactory(tv -> {
			TableRow<Pet> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && !row.isEmpty()) {
					Pet rowData = row.getItem();
					onDoubleClick(rowData);
				}
			});
			return row;
		});

		TableColumn<Pet, String> nameCol = new TableColumn<>(Messages.getString("PetTable.name")); //$NON-NLS-1$
		nameCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("name")); //$NON-NLS-1$

		TableColumn<Pet, String> raceCol = new TableColumn<>(Messages.getString("PetTable.race")); //$NON-NLS-1$
		raceCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("race")); //$NON-NLS-1$

		TableColumn<Pet, LocalDate> lastVisitCol = new TableColumn<>(Messages.getString("PetTable.lastVisit")); //$NON-NLS-1$
		lastVisitCol.setCellValueFactory(new PropertyValueFactory<Pet, LocalDate>("lastVisit")); //$NON-NLS-1$
		Callback<TableColumn<Pet, LocalDate>, TableCell<Pet, LocalDate>> defaultCellFactory = TextFieldTableCell
				.forTableColumn(new LocalDateStringConverter());
		lastVisitCol.setCellFactory(tc -> {
			TableCell<Pet, LocalDate> cell = defaultCellFactory.call(tc);
			cell.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$
			return cell;
		});

		TableColumn<Pet, String> customerCol = new TableColumn<>(Messages.getString("PetTable.customerId")); //$NON-NLS-1$
		customerCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("customerId")); //$NON-NLS-1$
		customerCol.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$

		table.getColumns().addAll(nameCol, raceCol, lastVisitCol);
		if (showCustomer) {
			table.getColumns().add(customerCol);
		}

		table.setItems(data);

		this.setSpacing(5);
		this.setPadding(new Insets(10, 0, 0, 10));
		this.getChildren().addAll(table);
	}

	protected void onDoubleClick(Pet rowData) {
		// nichts
	}
}
