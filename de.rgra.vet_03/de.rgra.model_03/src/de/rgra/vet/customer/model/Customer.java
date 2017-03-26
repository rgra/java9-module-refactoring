package de.rgra.vet.customer.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

	private IntegerProperty idProperty = new SimpleIntegerProperty(this, "id");

	private StringProperty nameProperty = new SimpleStringProperty(this, "name");

	private StringProperty streetProperty = new SimpleStringProperty(this, "street");

	private StringProperty zipcodeProperty = new SimpleStringProperty(this, "zipcode");

	private StringProperty cityProperty = new SimpleStringProperty(this, "city");

	public IntegerProperty getIdProperty() {
		return idProperty;
	}

	public int getId() {
		return idProperty.get();
	}

	public void setId(int value) {
		idProperty.set(value);
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

	public StringProperty getStreetProperty() {
		return streetProperty;
	}

	public String getStreet() {
		return streetProperty.get();
	}

	public void setStreet(String value) {
		streetProperty.set(value);
	}

	public StringProperty getZipcodeProperty() {
		return zipcodeProperty;
	}

	public String getZipcode() {
		return zipcodeProperty.get();
	}

	public void setZipcode(String value) {
		zipcodeProperty.set(value);
	}

	public StringProperty getCityProperty() {
		return cityProperty;
	}

	public String getCity() {
		return cityProperty.get();
	}

	public void setCity(String value) {
		cityProperty.set(value);
	}

}
