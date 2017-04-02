package de.rgra.vet.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Invoice {

	private IntegerProperty idProperty = new SimpleIntegerProperty(this, "id");

	private IntegerProperty customerIdProperty = new SimpleIntegerProperty(this, "customerId");

	private ObjectProperty<LocalDate> dateProperty = new SimpleObjectProperty<>(this, "date");

	private ObjectProperty<BigDecimal> totalProperty = new SimpleObjectProperty<>(this, "total");

	private BooleanProperty payedProperty = new SimpleBooleanProperty(this, "payed");

	public IntegerProperty getIdProperty() {
		return idProperty;
	}

	public int getId() {
		return idProperty.get();
	}

	public void setId(int value) {
		idProperty.set(value);
	}

	public IntegerProperty getCustomerIdProperty() {
		return customerIdProperty;
	}

	public int getCustomerId() {
		return customerIdProperty.get();
	}

	public void setCustomerId(int value) {
		customerIdProperty.set(value);
	}

	public ObjectProperty<LocalDate> getDateProperty() {
		return dateProperty;
	}

	public LocalDate getDate() {
		return dateProperty.get();
	}

	public void setDate(LocalDate value) {
		dateProperty.set(value);
	}

	public ObjectProperty<BigDecimal> getTotalProperty() {
		return totalProperty;
	}

	public BigDecimal getTotal() {
		return totalProperty.get();
	}

	public void setTotal(BigDecimal value) {
		totalProperty.set(value);
	}

	public BooleanProperty getPayedProperty() {
		return payedProperty;
	}

	public boolean getPayed() {
		return payedProperty.get();
	}

	public void setPayed(boolean value) {
		payedProperty.set(value);
	}

}
