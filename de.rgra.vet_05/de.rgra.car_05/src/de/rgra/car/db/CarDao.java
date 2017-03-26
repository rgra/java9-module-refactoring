package de.rgra.car.db;

import static de.rgra.vet.db.RandomUtils.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.rgra.car.model.Car;
import de.rgra.vet.customer.db.CustomerDao;
import de.rgra.vet.customer.model.Customer;

public class CarDao {

	private static final List<String> possibleNames = Arrays.asList("VW Golf", "VW Passat", "VW Polo", "Audi A3",
			"Opel Astra", "Mercedes C-Klasse", "VW Tiguan", "Skoda Octavia", "BMW 2er", "Audi A4", "Opel Corsa",
			"VW Touran", "Ford Focus", "Seat Leon", "BMW 3er", "Audi A6", "Skoda Fabia", "BMW 1er", "Ford Fiesta",
			"VW Transporter", "VW Up",  "Ford Kuga", "Audi Q3", "Mercedes A-Klasse", "VW Caddy", "BMW 5er",
			"Audi A1", "Nissan Qashqai", "Opel Mokka", "Mercedes B-Klasse", "Mercedes E-Klasse", "Fiat 500",
			"Fiat Ducato", "BMW X1", "Mercedes GLK, GLC", "Hyundai Tucson", "Audi A5, S5, RS5", "Opel Adam",
			"Skoda Superb", "Renault Clio", "Audi Q5", "Mercedes CLA-Klasse", "Smart Fortwo", "Hyundai i30",
			"Seat Ibiza", "Skoda Yeti", "Opel Insignia", "Hyundai i10", "BMW 4er", "Ford Mondeo", "Mazda CX-5",
			"Mitsubishi Mirage, Space Star", "Renault Twingo", "Kia Sportage", "Skoda Rapid", "Mercedes V-Klasse",
			"Opel Meriva", "Renault Captur", "Mercedes GLA", "Toyota Auris", "Mazda CX-3", "Ford C-Max",
			"Dacia Sandero", "Mercedes ML-Klasse, GLE", "Hyundai i20", "Toyota Yaris", "Audi Q7", "Peugeot 308",
			"Ford S-Max", "Peugeot 2008", "Skoda Citigo", "Suzuki Vitara", "Peugeot 208", "Opel Zafira",
			"Mitsubishi ASX", "Dacia Duster", "Renault Kadjar", "BMW X3", "Ford Transit, Tourneo", "VW Sharan",
			"Nissan Micra", "Mazda 3", "Toyota Aygo", "Seat Alhambra", "Citroen Berlingo", "Volvo XC60", "Opel Karl",
			"Nissan Juke", "Smart Forfour", "Renault Megane", "Mazda 2", "Ford B-Max", "Nissan X-Trail", "Citroen C4",
			"VW Beetle", "BMW X5", "Honda Civic", "Toyota RAV 4", "Audi TT");

	private static final List<String> possibleColors = Arrays.asList("Schwarz", "Weiss", "Rot", "Gelb", "Blau");

	private static final List<Car> cars = createCars();

	public List<Car> fetchCars() {
		return cars.stream().sorted(comparing(Car::getName))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public List<Car> fetchCarsForCustomer(int customerId) {
		return cars.stream().filter(car -> car.getCustomerId() == customerId).sorted(comparing(Car::getName))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private static List<Car> createCarsForCustomer(int customerId) {
		List<Car> result = new ArrayList<Car>();

		int numberCars = randomInt(3) + 1;

		Set<String> existingNames = new HashSet<>();
		for (int i = 0; i < numberCars; i++) {
			Car car = new Car();
			car.setId(i);
			car.setCustomerId(customerId);
			car.setName(uniqueRandom(existingNames, possibleNames));
			car.setType(car.getName().substring(0, car.getName().indexOf(" ")));
			car.setColor(random(possibleColors));
			car.setYear(2016 - randomInt(10));
			car.setLastVisit(randomDate());
			result.add(car);
		}

		return Collections.unmodifiableList(result);
	}

	private static List<Car> createCars() {
		List<Car> result = new ArrayList<Car>();

		for (Customer customer : new CustomerDao().fetchCustomers()) {
			result.addAll(createCarsForCustomer(customer.getId()));
		}
		return result;
	}

}
