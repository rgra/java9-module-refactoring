package de.rgra.vet.visit;

import static de.rgra.vet.RandomUtils.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import de.rgra.vet.pet.Pet;
import de.rgra.vet.pet.PetDao;

public class VisitDao {

	private static final List<String> notes = Arrays.asList("Entwurmt", "Geimpft", "Bruch beim Röntgen festgestellt");
	private static final List<Visit> visits = createVisits();

	public List<Visit> getVisitsByPetId(int petId) {
		return visits.stream().filter(visit -> visit.getPetId() == petId).sorted(comparing(Visit::getDateTime).reversed())
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private static List<Visit> createVisits() {
		List<Visit> result = new ArrayList<>();

		for (Pet pet : new PetDao().fetchPets()) {
			result.addAll(createVisits(pet.getId()));
		}
		AtomicInteger id = new AtomicInteger(1);
		result.forEach(visit -> visit.setId(id.getAndIncrement()));

		return Collections.unmodifiableList(result);
	}

	private static List<Visit> createVisits(int petId) {
		List<Visit> result = new ArrayList<>();

		for (int i = 0; i < randomInt(8) + 1; i++) {
			Visit visit = new Visit();
			visit.setPetId(petId);
			visit.setDateTime(randomDateTime());
			visit.setMinutes(randomInt(120) + 15);
			visit.setNote(random(notes));
			result.add(visit);
		}

		return result;
	}
}
