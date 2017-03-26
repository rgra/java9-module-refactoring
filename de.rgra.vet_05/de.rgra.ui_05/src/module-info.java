module de.rgra.ui_05 {
	
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires transitive de.rgra.model_05;
	
	exports de.rgra.vet.customer.ui;
	exports de.rgra.vet.invoice.ui;
	exports de.rgra.vet.visit.ui;
	exports de.rgra.vet.ui;
	exports de.rgra.vet.customer.spi;
	
	uses de.rgra.vet.customer.spi.CustomerViewTabService;
}
