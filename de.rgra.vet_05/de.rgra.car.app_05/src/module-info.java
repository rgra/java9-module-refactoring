module de.rgra.car.app_05 {
	
	requires de.rgra.app_05;
	requires de.rgra.car_05;
	
	exports de.rgra.car.app.nl;
	
	provides de.rgra.app.spi.ApplicationConfigurationProvider
	 	with de.rgra.car.app.CarAppConfiguration;
}