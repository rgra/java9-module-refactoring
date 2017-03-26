module de.rgra.pet_03 {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	requires de.rgra.model_03;
	requires de.rgra.ui_03;
	
	exports de.rgra.vet.pet.db;
	exports de.rgra.vet.pet.model;
	exports de.rgra.vet.pet.ui;
}