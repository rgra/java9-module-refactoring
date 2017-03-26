package de.rgra.vet.invoice.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import de.rgra.vet.invoice.model.Invoice;
import de.rgra.vet.invoice.nl.Messages;
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
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class InvoiceTable extends VBox {

	@SuppressWarnings("unchecked")
	public InvoiceTable(List<Invoice> invoices) {
		final ObservableList<Invoice> data = FXCollections.observableArrayList(invoices);

		TableView<Invoice> table = new TableView<>();
		table.setEditable(false);
		table.setRowFactory(tv -> {
			TableRow<Invoice> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && !row.isEmpty()) {
					Invoice rowData = row.getItem();
					onDoubleClick(rowData);
				}
			});
			return row;
		});

		TableColumn<Invoice, LocalDate> invoiceDataCol = new TableColumn<>(Messages.getString("InvoiceTable.date")); //$NON-NLS-1$
		invoiceDataCol.setCellValueFactory(new PropertyValueFactory<Invoice, LocalDate>("date")); //$NON-NLS-1$
		Callback<TableColumn<Invoice, LocalDate>, TableCell<Invoice, LocalDate>> dateCellFactory = TextFieldTableCell
				.forTableColumn(new LocalDateStringConverter());
		invoiceDataCol.setCellFactory(tc -> {
			TableCell<Invoice, LocalDate> cell = dateCellFactory.call(tc);
			cell.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$
			return cell;
		});

		TableColumn<Invoice, BigDecimal> totalCol = new TableColumn<>(Messages.getString("InvoiceTable.total")); //$NON-NLS-1$
		totalCol.setCellValueFactory(new PropertyValueFactory<Invoice, BigDecimal>("total")); //$NON-NLS-1$
		Callback<TableColumn<Invoice, BigDecimal>, TableCell<Invoice, BigDecimal>> bigDecimalCellFactory = TextFieldTableCell
				.forTableColumn(new BigDecimalStringConverter() {
					@Override
					public String toString(BigDecimal value) {
						return NumberFormat.getCurrencyInstance().format(value);
					}
				});
		totalCol.setCellFactory(tc -> {
			TableCell<Invoice, BigDecimal> cell = bigDecimalCellFactory.call(tc);
			cell.setStyle("-fx-alignment: BASELINE_RIGHT;"); //$NON-NLS-1$
			return cell;
		});

		TableColumn<Invoice, Boolean> payedCol = new TableColumn<>(Messages.getString("InvoiceTable.payed")); //$NON-NLS-1$
		payedCol.setCellValueFactory(new PropertyValueFactory<Invoice, Boolean>("payed")); //$NON-NLS-1$
		Callback<TableColumn<Invoice, Boolean>, TableCell<Invoice, Boolean>> booleanCellFactory = TextFieldTableCell
				.forTableColumn(new BooleanStringConverter() {
					@Override
					public String toString(Boolean value) {
						if (Boolean.TRUE.equals(value)) {
							return Messages.getString("InvoiceTable.yes"); //$NON-NLS-1$
						}
						return Messages.getString("InvoiceTable.no"); //$NON-NLS-1$
					}
				});
		payedCol.setCellFactory(tc -> {
			TableCell<Invoice, Boolean> cell = booleanCellFactory.call(tc);
			cell.setStyle("-fx-alignment: CENTER;"); //$NON-NLS-1$
			return cell;
		});

		table.getColumns().addAll(invoiceDataCol, totalCol, payedCol);
		table.setItems(data);

		this.setSpacing(5);
		this.setPadding(new Insets(10, 0, 0, 10));
		this.getChildren().addAll(table);
	}

	protected void onDoubleClick(Invoice rowData) {
		// nichts
	}
}
