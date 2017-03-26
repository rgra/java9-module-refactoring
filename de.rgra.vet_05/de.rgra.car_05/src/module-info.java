module de.rgra.car_05 {
	requires de.rgra.ui_05;
	
	exports de.rgra.car.db;
	exports de.rgra.car.model;
	exports de.rgra.car.spi;
	exports de.rgra.car.ui;
	
	provides de.rgra.vet.customer.spi.CustomerViewTabService 
	   with de.rgra.car.spi.CarCustomerViewTabService;
}