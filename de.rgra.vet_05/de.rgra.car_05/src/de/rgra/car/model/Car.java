package de.rgra.car.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {

	private final IntegerProperty idProperty = new SimpleIntegerProperty(this, "id");

	private final IntegerProperty customerIdProperty = new SimpleIntegerProperty(this, "customerId");

	private final StringProperty nameProperty = new SimpleStringProperty(this, "name");

	private final StringProperty typeProperty = new SimpleStringProperty(this, "type");
	
	private final StringProperty colorProperty = new SimpleStringProperty(this, "color");
	
	private final IntegerProperty yearProperty = new SimpleIntegerProperty(this, "year");

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

	public StringProperty getTypeProperty() {                
		return typeProperty;                                    
	}                                                       
	                                                        
	public String getType() {             
		return typeProperty.get();                     
	}                                                       
	                                                        
	public void setType(String value) {   
		typeProperty.set(value);                       
	}                                                       

	public StringProperty getColorProperty() {                
		return colorProperty;                                    
	}                                                       
	                                                        
	public String getColor() {             
		return colorProperty.get();                     
	}                                                       
	                                                        
	public void setColor(String value) {   
		colorProperty.set(value);                       
	}                                                       

	public IntegerProperty getYearProperty() {                
		return yearProperty;                                    
	}                                                       
	                                                        
	public int getYear() {             
		return yearProperty.get();                     
	}                                                       
	                                                        
	public void setYear(int value) {   
		yearProperty.set(value);                       
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
