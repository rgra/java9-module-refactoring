package de.rgra.vet;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import de.rgra.vet.customer.db.CustomerDao;
import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.ui.CustomerNavigationNode;
import de.rgra.vet.customer.ui.CustomerTable;
import de.rgra.vet.nl.Messages;
import de.rgra.vet.pet.model.Pet;
import de.rgra.vet.pet.ui.PetTable;
import de.rgra.vet.pet.ui.PetView;
import de.rgra.vet.pet.ui.WaitingRoom;
import de.rgra.vet.ui.NavigationNode;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VetServicesApplication extends javafx.application.Application {

	private BorderPane border;

	private WaitingRoom waitingRoom = new WaitingRoom();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(Messages.getString("VetServicesApplication.title")); //$NON-NLS-1$
		primaryStage.getIcons().add(new Image("/de/rgra/vet/vet_symbol.png")); //$NON-NLS-1$

		border = new BorderPane();
		border.setTop(createToolbar());
		border.setBottom(createStatusLine());
		border.setCenter(createMainPane());
		border.setLeft(createNavigation());

		Scene scene = new Scene(border, 1020, 800);
		scene.getStylesheets().add("/de/rgra/vet/test.css"); //$NON-NLS-1$
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	private Node createMainPane() {
		BorderPane border = new BorderPane();
		border.setTop(new Label(Messages.getString("VetServicesApplication.dashboard"))); //$NON-NLS-1$
		return border;
	}

	private Node createNavigation() {
		TreeItem<NavigationNode> rootItem = new TreeItem<>(new NavigationNode(Messages.getString("VetServicesApplication.navigation"))); //$NON-NLS-1$
		rootItem.setExpanded(true);

		TreeItem<NavigationNode> waitingNode = new TreeItem<>(new NavigationNode(Messages.getString("VetServicesApplication.waitingroom")) { //$NON-NLS-1$
			@Override
			public Node createNode() {
				return new PetTable(waitingRoom.getPets(), true) {
					@Override
					protected void onDoubleClick(Pet pet) {
						border.setCenter(new PetView(new CustomerDao().fetchCustomer(pet.getCustomerId()), pet));
					}
				};
			}
		});
		rootItem.getChildren().add(waitingNode);

		List<Customer> allCustomers = new CustomerDao().fetchCustomers();
		TreeItem<NavigationNode> customerItem = new TreeItem<>(new NavigationNode(Messages.getString("VetServicesApplication.customers")) { //$NON-NLS-1$
			@Override
			public Node createNode() {
				return new CustomerTable(allCustomers);
			}
		});
		rootItem.getChildren().add(customerItem);

		for (Customer customer : allCustomers) {
			customerItem.getChildren().add(new TreeItem<>(new CustomerNavigationNode(customer)));
		}
		customerItem.setExpanded(true);

		TreeView<NavigationNode> tree = new TreeView<>(rootItem);
		tree.setShowRoot(false);
		tree.setCellFactory(param -> new TreeCellNavigationNode());
		tree.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				TreeItem<NavigationNode> item = tree.getSelectionModel().getSelectedItem();
				if (item != null) {
					showMessage(item.getValue());
				}
			}
		});
		tree.getSelectionModel().select(waitingNode);
		showMessage(waitingNode.getValue());
		return tree;
	}

	private void showMessage(NavigationNode navigationNode) {
		border.setCenter(navigationNode.createNode());
	}

	public HBox createToolbar() {
		HBox hbox = new HBox();
		hbox.getStyleClass().add("toolbar"); //$NON-NLS-1$
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		Button buttonProjected = new Button(Messages.getString("VetServicesApplication.customer.search")); //$NON-NLS-1$
		buttonProjected.setPrefSize(100, 20);

		hbox.getChildren().addAll(buttonProjected);

		return hbox;
	}

	private Node createStatusLine() {
		HBox hbox = new HBox();
		hbox.getStyleClass().add("statusline"); //$NON-NLS-1$
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.getChildren().add(new Label(MessageFormat.format(Messages.getString("VetServicesApplication.waitingroom.text"), waitingRoom.getPets().size()))); //$NON-NLS-1$
		return hbox;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.GERMAN);
		launch(args);
	}

	private static final class TreeCellNavigationNode extends TreeCell<NavigationNode> {
		@Override
		protected void updateItem(NavigationNode item, boolean empty) {
			super.updateItem(item, empty);

			if (empty || item == null) {
				setText(null);
				setGraphic(null);
			} else {
				setText(item.getText());
			}
		}
	}

}
