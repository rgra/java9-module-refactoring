package de.rgra.vet;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;

import de.rgra.app.MainApplication;
import de.rgra.app.spi.ApplicationConfigurationProvider;
import de.rgra.vet.customer.db.CustomerDao;
import de.rgra.vet.nl.Messages;
import de.rgra.vet.pet.model.Pet;
import de.rgra.vet.pet.ui.PetTable;
import de.rgra.vet.pet.ui.PetView;
import de.rgra.vet.pet.ui.WaitingRoom;
import de.rgra.vet.ui.NavigationNode;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class VetAppConfiguration implements ApplicationConfigurationProvider {
	
	private WaitingRoom waitingRoom = new WaitingRoom();

	@Override
	public NavigationNode getStartNode(BorderPane border) {
		return new NavigationNode(Messages.getString("VetServicesApplication.waitingroom")) { //$NON-NLS-1$
			@Override
			public Node createNode() {
				return new PetTable(waitingRoom.getPets(), true) {
					@Override
					protected void onDoubleClick(Pet pet) {
						border.setCenter(new PetView(new CustomerDao().fetchCustomer(pet.getCustomerId()), pet));
					}
				};
			}
		};
	}

	@Override
	public String getTitle() {
		return Messages.getString("VetServicesApplication.title");
	}

	@Override
	public Image getImage() {
		URL url = VetAppConfiguration.class.getResource("vet_symbol.png");
		return new Image(url.toString());
	}

	@Override
	public URL getStyleSheet() {
		return VetAppConfiguration.class.getResource("test.css");
	}

	@Override
	public Node getStatusLine() {
		return new Label(MessageFormat.format(Messages.getString("VetServicesApplication.waitingroom.text"), waitingRoom.getPets().size())); //$NON-NLS-1$
	}
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.GERMAN);
		MainApplication.launch(MainApplication.class,args);
	}

}
