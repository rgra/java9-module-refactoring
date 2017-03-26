package de.rgra.vet.visit.db;

import static de.rgra.vet.db.RandomUtils.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import de.rgra.vet.visit.model.Visit;

public class VisitDao {

	private static final List<String> notes = Arrays.asList("");
	private static final List<Visit> visits = createVisits();

	public List<Visit> getVisitsByForeignId(int foreignId) {
		return visits.stream().filter(visit -> visit.getForeignId() == foreignId)
				.sorted(comparing(Visit::getDateTime).reversed())
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private static List<Visit> createVisits() {
		List<Visit> result = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			result.addAll(createVisits(i));
		}
		AtomicInteger id = new AtomicInteger(1);
		result.forEach(visit -> visit.setId(id.getAndIncrement()));

		return Collections.unmodifiableList(result);
	}

	private static List<Visit> createVisits(int foreignId) {
		List<Visit> result = new ArrayList<>();

		for (int i = 0; i < randomInt(8) + 1; i++) {
			Visit visit = new Visit();
			visit.setForeignId(foreignId);
			visit.setDateTime(randomDateTime());
			visit.setMinutes(randomInt(120) + 15);
			visit.setNote(random(notes));
			result.add(visit);
		}

		return result;
	}
}
