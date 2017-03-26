package de.rgra.car.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.rgra.car.db.CarDao;
import de.rgra.car.model.Car;

public class WorkItemList {

	private List<Car> cars;

	public WorkItemList() {
		cars = initialCars();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private static List<Car> initialCars() {
		List<Car> result = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			result.add(new CarDao().fetchCarsForCustomer(i).get(0));
		}
		return result;
	}
}
