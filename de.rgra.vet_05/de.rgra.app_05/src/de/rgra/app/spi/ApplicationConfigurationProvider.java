package de.rgra.app.spi;

import java.net.URL;

import de.rgra.vet.ui.NavigationNode;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public interface ApplicationConfigurationProvider {

	public NavigationNode getStartNode(BorderPane border);

	public String getTitle();

	public Image getImage();

	public URL getStyleSheet();

	public Node getStatusLine();

}
