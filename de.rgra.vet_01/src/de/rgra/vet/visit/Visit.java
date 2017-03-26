package de.rgra.vet.visit;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Visit {
	private IntegerProperty idProperty = new SimpleIntegerProperty(this, "id");

	private IntegerProperty petIdProperty = new SimpleIntegerProperty(this, "petId");

	private ObjectProperty<LocalDateTime> dateTimeProperty = new SimpleObjectProperty<LocalDateTime>(this, "dateTime");

	private StringProperty noteProperty = new SimpleStringProperty(this, "note");

	private LongProperty minutesProperty = new SimpleLongProperty(this, "minutes");

	private ObjectProperty<LocalDate> invoiceDateProperty = new SimpleObjectProperty<LocalDate>(this, "invoiceDate");

	public IntegerProperty getIdProperty() {
		return idProperty;
	}

	public int getId() {
		return idProperty.get();
	}

	public void setId(int value) {
		idProperty.set(value);
	}

	public IntegerProperty getPetIdProperty() {
		return petIdProperty;
	}

	public int getPetId() {
		return petIdProperty.get();
	}

	public void setPetId(int value) {
		petIdProperty.set(value);
	}

	public ObjectProperty<LocalDateTime> getDateTimeProperty() {
		return dateTimeProperty;
	}

	public java.time.LocalDateTime getDateTime() {
		return dateTimeProperty.get();
	}

	public void setDateTime(java.time.LocalDateTime value) {
		dateTimeProperty.set(value);
	}

	public StringProperty getNoteProperty() {
		return noteProperty;
	}

	public String getNote() {
		return noteProperty.get();
	}

	public void setNote(String value) {
		noteProperty.set(value);
	}

	public LongProperty getMinutesProperty() {
		return minutesProperty;
	}

	public long getMinutes() {
		return minutesProperty.get();
	}

	public void setMinutes(long value) {
		minutesProperty.set(value);
	}

	public ObjectProperty<LocalDate> getInvoiceDateProperty() {
		return invoiceDateProperty;
	}

	public java.time.LocalDate getInvoiceDate() {
		return invoiceDateProperty.get();
	}

	public void setInvoiceDate(java.time.LocalDate value) {
		invoiceDateProperty.set(value);
	}

}
