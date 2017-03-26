package de.rgra.vet.ui;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class NavigationNode {

	private final String text;

	public NavigationNode(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public Node createNode() {
		Button button = new Button();
		button.setText(text);
		return button;
	}

}