module de.rgra.model_05 {
	requires transitive java.base;
	requires transitive javafx.base;
	
	exports de.rgra.vet.customer.model;   
    exports de.rgra.vet.customer.db;    
    exports de.rgra.vet.invoice.model;  
    exports de.rgra.vet.invoice.db;  
    exports de.rgra.vet.visit.db;  
    exports de.rgra.vet.visit.model;  
    exports de.rgra.vet.db;
}
