module de.rgra.pet_05 {
	requires de.rgra.ui_05;
	
	exports de.rgra.vet.pet.db;
	exports de.rgra.vet.pet.model;
	exports de.rgra.vet.pet.ui;
	
	provides de.rgra.vet.customer.spi.CustomerViewTabService 
	   with de.rgra.vet.pet.spi.PetCustomerViewTabService;
}