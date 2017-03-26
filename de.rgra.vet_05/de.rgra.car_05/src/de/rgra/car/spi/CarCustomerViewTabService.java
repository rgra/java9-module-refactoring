package de.rgra.car.spi;

import java.util.ArrayList;
import java.util.List;

import de.rgra.car.db.CarDao;
import de.rgra.car.model.Car;
import de.rgra.car.nl.Messages;
import de.rgra.car.ui.CarTable;
import de.rgra.car.ui.CarView;
import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.customer.spi.CustomerViewTabService;
import de.rgra.vet.customer.ui.CustomerView;
import javafx.scene.Node;
import javafx.scene.control.Tab;

public class CarCustomerViewTabService implements CustomerViewTabService {

	@Override
	public List<Tab> createTabs(CustomerView view, Customer customer) {
		List<Tab> tabs = new ArrayList<>();
		tabs.add(createTab(Messages.getString("CustomerView.cars"), createCarNode(view, customer))); //$NON-NLS-1$
		return tabs;
	}

	private Node createCarNode(CustomerView view, Customer customer) {
		List<Car> cars = new CarDao().fetchCarsForCustomer(customer.getId());
		CarTable table = new CarTable(cars, false) {
			@Override
			protected void onDoubleClick(Car car) {
				view.replace(new CarView(customer, car));
			}
		};
		return table;
	}

	// ######
	private Tab createTab(String name, Node node) {
		Tab tab = new Tab();
		tab.setText(name);
		tab.setContent(node);
		return tab;
	}

}
