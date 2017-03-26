package de.rgra.vet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomUtils {

	private static final Random random = new Random();

	public static boolean randomBoolean() {
		return random.nextBoolean();
	}

	public static int randomInt(int max) {
		return random.nextInt(max);
	}

	public static LocalDate randomDate() {
		return LocalDate.now().minusDays(random.nextInt(180));
	}

	public static LocalDateTime randomDateTime() {
		return LocalDate.now().atTime(18, 0).minusDays(random.nextInt(180)).minusMinutes(random.nextInt(8 * 60));
	}

	public static <T> T random(List<T> list) {
		return list.get(random.nextInt(list.size()));
	}

	public static String uniqueRandom(Set<String> existingNames, List<String> list) {
		String randomName = random(list);
		while (!existingNames.add(randomName)) {
			randomName = random(list);
		}
		return randomName;
	}
}
