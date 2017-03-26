package de.rgra.vet.pet.db;

import static de.rgra.vet.db.RandomUtils.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.rgra.vet.customer.db.CustomerDao;
import de.rgra.vet.customer.model.Customer;
import de.rgra.vet.pet.model.Pet;

public class PetDao {

	private static final List<String> possibleNames = Arrays.asList("Charlyn", "Wai", "Karly", "Timmy", "Jani",
			"Arletha", "Roselee", "Verlene", "Marti", "Elton", "Kiesha", "Lisa", "Trisha", "Carmela", "Nora", "Kathi",
			"Marcie", "Rachelle", "Shin", "Shelby", "Colette", "Indira", "Kristyn", "Horacio", "Leatrice", "Shellie",
			"Tabetha", "Evelyne", "Marcellus", "Gracia", "Shonda", "Rochelle", "Guy", "Gale", "Hugh", "Azucena",
			"Adelaida", "Armanda", "Letisha", "Rosa", "Clint", "Rex", "Jacki", "Gavin", "Leota", "Dacia", "Candy",
			"Luciana", "Zulma", "Deloras");
	private static final List<String> possibleRaces = Arrays.asList("Hund", "Katze", "Papagei", "Pferd", "Huhn",
			"Salamander", "Schaf", "Ziege", "Kuh");

	private static final List<Pet> pets = createPets();

	public List<Pet> fetchPets() {
		return pets.stream().sorted(comparing(Pet::getName))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public List<Pet> fetchPetsForCustomer(int customerId) {
		return pets.stream().filter(pet -> pet.getCustomerId() == customerId).sorted(comparing(Pet::getName))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private static List<Pet> createPetsForCustomer(int customerId) {
		List<Pet> result = new ArrayList<Pet>();

		int numberPets = randomInt(3) + 1;

		Set<String> existingNames = new HashSet<>();
		for (int i = 0; i < numberPets; i++) {
			Pet pet = new Pet();
			pet.setId(i);
			pet.setCustomerId(customerId);
			pet.setName(uniqueRandom(existingNames, possibleNames));
			pet.setRace(random(possibleRaces));
			pet.setLastVisit(randomDate());
			result.add(pet);
		}

		return Collections.unmodifiableList(result);
	}

	private static List<Pet> createPets() {
		List<Pet> result = new ArrayList<Pet>();

		for (Customer customer : new CustomerDao().fetchCustomers()) {
			result.addAll(createPetsForCustomer(customer.getId()));
		}
		return result;
	}

}
