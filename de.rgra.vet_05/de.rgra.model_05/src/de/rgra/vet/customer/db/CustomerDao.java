package de.rgra.vet.customer.db;

import static de.rgra.vet.db.RandomUtils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.rgra.vet.customer.model.Customer;

public class CustomerDao {

	private static final int MIN_CUSTOMER_ID = 1;

	private static final int MAX_CUSTOMER_ID = 6;

	private static final List<String> possibleNames = Arrays.asList("Lorrine Lamar", "Elizabet Sisk", "Jonna Burchell", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			"Percy Ramm", "Rafaela Knoblock", "Otelia Villani", "Lee Hentz", "Coral Cade", "Lia Malchow", "Deb Sacks", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			"Paz Goosby", "Veronica Earnest", "Lavada Bodden", "Yelena Sorrentino", "Shanna Starbird", "Lena Wetherbee", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"Jamal Rasmussen", "Tameika Alva", "Robyn Shick", "Verna Erdmann", "Ariel Eugene", "Stacee Hight", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"Maude Deforest", "Shantelle Mccarley", "Dinorah Zulauf", "Maple Mcmullan", "Cristie Rader", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			"Eloisa Armenta", "Joie Rampton", "Belkis Mandell", "Taryn Tom", "Kena Willison", "Chuck Dyches", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"Diann Lesser", "Jesenia Manz", "Tabatha Haug", "Harriett Seaborn", "Harry Gossage", "Macy Faux", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"Tai Harry", "Jeanett Edmiston", "Dyan Glad", "Xuan Blandford", "Carri Ronquillo", "Sylvia Vogler", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"Sina Shirk", "Marla Wherry", "Caleb Franzoni", "Jarod Charon", "Claretta Rega"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	private static final List<StreetZip> streets = readStreets();

	private static final List<Customer> customers = createCustomers();

	public List<Customer> fetchCustomers() {
		return customers;
	}

	public Customer fetchCustomer(int customerId) {
		return customers.stream().filter(customer -> customer.getId() == customerId).findAny().orElse(null);
	}

	private static List<Customer> createCustomers() {
		List<Customer> result = new ArrayList<>();

		Set<String> existingNames = new HashSet<>();
		for (int customerId = MIN_CUSTOMER_ID; customerId <= MAX_CUSTOMER_ID; customerId++) {
			Customer customer = new Customer();
			customer.setId(customerId);
			customer.setName(uniqueRandom(existingNames, possibleNames));
			StreetZip random = random(streets);
			customer.setStreet(random.getStreet() + " " + (randomInt(50) + 1)); //$NON-NLS-1$
			customer.setZipcode(random.getZipCode());
			customer.setCity("Bremen"); //$NON-NLS-1$
			result.add(customer);
		}

		return Collections.unmodifiableList(result);
	}

	private static List<StreetZip> readStreets() {
		List<StreetZip> result = new ArrayList<>();

		try {
			InputStream resourceAsStream = CustomerDao.class.getResourceAsStream("streets.csv"); //$NON-NLS-1$
			List<String> streetLines = linesFromStream(resourceAsStream);

			for (String string : streetLines) {
				String[] split = string.split(";"); //$NON-NLS-1$
				if (split.length == 2) {
					result.add(new StreetZip(split[0], split[1]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(result);
	}

	private static List<String> linesFromStream(InputStream resourceAsStream) throws IOException {
		List<String> streetLines = new ArrayList<>();
		try (Reader reader = new InputStreamReader(resourceAsStream, StandardCharsets.ISO_8859_1.newDecoder());
				BufferedReader br = new BufferedReader(reader)) {

			for (;;) {
				String line = br.readLine();
				if (line == null)
					break;
				streetLines.add(line);
			}
		}
		return streetLines;
	}

	public static class StreetZip {
		private final String street;

		private final String zipCode;

		public StreetZip(String street, String zipCode) {
			super();
			this.street = street;
			this.zipCode = zipCode;
		}

		public String getStreet() {
			return street;
		}

		public String getZipCode() {
			return zipCode;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((street == null) ? 0 : street.hashCode());
			result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StreetZip other = (StreetZip) obj;
			if (street == null) {
				if (other.street != null)
					return false;
			} else if (!street.equals(other.street))
				return false;
			if (zipCode == null) {
				if (other.zipCode != null)
					return false;
			} else if (!zipCode.equals(other.zipCode))
				return false;
			return true;
		}

	}

}
