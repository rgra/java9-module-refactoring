module de.rgra.app_05 {
	requires transitive de.rgra.ui_05;
	
	exports de.rgra.app.spi;
	exports de.rgra.app;
	
	uses de.rgra.app.spi.ApplicationConfigurationProvider;
}