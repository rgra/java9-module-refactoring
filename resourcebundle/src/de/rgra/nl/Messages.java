package de.rgra.nl;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	
	// this works in Java 9 Module
	// private static final String BUNDLE_NAME = "de.rgra.nl.Messages";

	// this doesn't work in Java 9 Module
	private static final String BUNDLE_NAME = "de.rgra.nl.messages";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static void main(String[] args) {
		System.out.println("Java " + System.getProperty("java.version") + ": " + Messages.getString("I18n.message"));
	}
}
