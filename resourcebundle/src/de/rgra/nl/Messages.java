package de.rgra.nl;

import java.util.ResourceBundle;

public class Messages {

	public static void main(String[] args) {
		System.out.print("Java " + System.getProperty("java.version") + ": ");
		// this works in Java 9 Module
		// ResourceBundle bundle =
		// ResourceBundle.getBundle("de.rgra.nl.Messages");
		// this doesn't work in Java 9 Module
		ResourceBundle bundle = ResourceBundle.getBundle("de.rgra.nl.messages");
		System.out.println(bundle.getString("I18n.message"));
	}
}
