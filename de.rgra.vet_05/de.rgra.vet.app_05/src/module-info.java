module de.rgra.vet.app_05 {
	
	requires de.rgra.app_05;
	requires de.rgra.pet_05;
	
	provides de.rgra.app.spi.ApplicationConfigurationProvider
	 	with de.rgra.vet.VetAppConfiguration;
}