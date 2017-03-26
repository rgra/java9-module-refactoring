module de.rgra.pet_04 {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	requires de.rgra.model_04;
	requires de.rgra.ui_04;
	
	exports de.rgra.vet.pet.db;
	exports de.rgra.vet.pet.model;
	exports de.rgra.vet.pet.ui;
	
	provides de.rgra.vet.customer.spi.CustomerViewTabService 
	   with de.rgra.vet.pet.spi.PetCustomerViewTabService;
}