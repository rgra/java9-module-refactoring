module de.rgra.ui_03 {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	
	requires de.rgra.model_03;
	
	exports de.rgra.vet.customer.ui;
	exports de.rgra.vet.invoice.ui;
	exports de.rgra.vet.visit.ui;
	exports de.rgra.vet.ui;
}
