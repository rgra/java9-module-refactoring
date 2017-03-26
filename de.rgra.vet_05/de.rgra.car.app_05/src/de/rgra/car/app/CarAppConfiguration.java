package de.rgra.car.app;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;

import de.rgra.app.MainApplication;
import de.rgra.app.spi.ApplicationConfigurationProvider;
import de.rgra.car.app.nl.Messages;
import de.rgra.car.model.Car;
import de.rgra.car.ui.CarTable;
import de.rgra.car.ui.CarView;
import de.rgra.car.ui.WorkItemList;
import de.rgra.vet.customer.db.CustomerDao;
import de.rgra.vet.ui.NavigationNode;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class CarAppConfiguration implements ApplicationConfigurationProvider {

	private WorkItemList workItems = new WorkItemList();

	@Override
	public NavigationNode getStartNode(BorderPane border) {
		return new NavigationNode(Messages.getString("CarServicesApplication.waitingroom")) { //$NON-NLS-1$
			@Override
			public Node createNode() {
				return new CarTable(workItems.getCars(), true) {
					@Override
					protected void onDoubleClick(Car car) {
						border.setCenter(new CarView(new CustomerDao().fetchCustomer(car.getCustomerId()), car));
					}
				};
			}
		};
	}

	@Override
	public String getTitle() {
		return Messages.getString("CarServicesApplication.title");
	}

	@Override
	public Image getImage() {
		URL url = CarAppConfiguration.class.getResource("car_symbol.png");
		return new Image(url.toString());
	}

	@Override
	public URL getStyleSheet() {
		return CarAppConfiguration.class.getResource("test.css");
	}

	@Override
	public Node getStatusLine() {
		return new Label(MessageFormat.format(Messages.getString("CarServicesApplication.waitingroom.text"), //$NON-NLS-1$
				workItems.getCars().size()));
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.GERMAN);
		MainApplication.launch(MainApplication.class, args);
	}

}
