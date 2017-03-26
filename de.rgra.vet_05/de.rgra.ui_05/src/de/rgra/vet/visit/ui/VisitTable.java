package de.rgra.vet.visit.ui;

import java.time.LocalDateTime;
import java.util.List;

import de.rgra.vet.visit.model.Visit;
import de.rgra.vet.visit.nl.Messages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.converter.LocalDateTimeStringConverter;

public class VisitTable extends VBox {

	@SuppressWarnings("unchecked")
	public VisitTable(List<Visit> visits, boolean showCustomer) {
		final ObservableList<Visit> data = FXCollections.observableArrayList(visits);

		TableView<Visit> table = new TableView<>();
		table.setEditable(false);

		TableColumn<Visit, LocalDateTime> lastVisitCol = new TableColumn<>(Messages.getString("VisitTable.lastVisit")); //$NON-NLS-1$
		lastVisitCol.setCellValueFactory(new PropertyValueFactory<Visit, LocalDateTime>("dateTime")); //$NON-NLS-1$
		Callback<TableColumn<Visit, LocalDateTime>, TableCell<Visit, LocalDateTime>> defaultCellFactory = TextFieldTableCell
				.forTableColumn(new LocalDateTimeStringConverter());
		lastVisitCol.setCellFactory(tc -> {
			TableCell<Visit, LocalDateTime> cell = defaultCellFactory.call(tc);
			cell.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$
			return cell;
		});
		
		TableColumn<Visit, String> minutesCol = new TableColumn<>(Messages.getString("VisitTable.minutes")); //$NON-NLS-1$
		minutesCol.setCellValueFactory(new PropertyValueFactory<Visit, String>("minutes")); //$NON-NLS-1$

		TableColumn<Visit, String> noteCol = new TableColumn<>(Messages.getString("VisitTable.note")); //$NON-NLS-1$
		noteCol.setCellValueFactory(new PropertyValueFactory<Visit, String>("note")); //$NON-NLS-1$

		table.getColumns().addAll(lastVisitCol, minutesCol, noteCol);

		table.setItems(data);

		this.setSpacing(5);
		this.setPadding(new Insets(10, 0, 0, 10));
		this.getChildren().addAll(table);
	}
}
