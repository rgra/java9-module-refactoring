module de.rgra.ui_04 {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	requires de.rgra.model_04;
	
	exports de.rgra.vet.customer.ui;
	exports de.rgra.vet.invoice.ui;
	exports de.rgra.vet.visit.ui;
	exports de.rgra.vet.ui;
	exports de.rgra.vet.customer.spi;
	
	uses de.rgra.vet.customer.spi.CustomerViewTabService;
}
