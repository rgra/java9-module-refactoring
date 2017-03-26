package de.rgra.vet.pet.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pet {

	private final IntegerProperty idProperty = new SimpleIntegerProperty(this, "id");

	private final IntegerProperty customerIdProperty = new SimpleIntegerProperty(this, "customerId");

	private final StringProperty nameProperty = new SimpleStringProperty(this, "name");

	private final StringProperty raceProperty = new SimpleStringProperty(this, "race");

	private final ObjectProperty<LocalDate> lastVisitProperty = new SimpleObjectProperty<LocalDate>(this, "lastVisit");

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

	public StringProperty getNameProperty() {
		return nameProperty;
	}

	public String getName() {
		return nameProperty.get();
	}

	public void setName(String value) {
		nameProperty.set(value);
	}

	public StringProperty getRaceProperty() {
		return raceProperty;
	}

	public String getRace() {
		return raceProperty.get();
	}

	public void setRace(String value) {
		raceProperty.set(value);
	}

	public ObjectProperty<LocalDate> getLastVisitProperty() {
		return lastVisitProperty;
	}

	public LocalDate getLastVisit() {
		return lastVisitProperty.get();
	}

	public void setLastVisit(LocalDate value) {
		lastVisitProperty.set(value);
	}


}
