import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// Prints are each item of the Stream.
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));

		// Prints are each item of the Stream.
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		});

		// Prints are each item of the Stream. Map each element to string and
		// Uppercase each element
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));

		// Declare List of Person objects with name and age.
		List<Person> persons = Arrays.asList(new Person("Mike", 18),
				new Person("Matt", 23), new Person("John", 23), new Person(
						"Stephen", 12));

		// Create a sorted List from above of Person objects by person age.
		// Declares a stream and map the age for each person. Sort the list by
		// person age.
		List<Integer> personsSorted = persons.stream().map(Person::getAge)
				.sorted().collect(Collectors.toList());

		System.out.println("Person Sorted: " + personsSorted);

		// Declare List of Person objects. Filter list on Element that start
		// with M and puts these elements in a new list. Mike and Matt
		List<Person> filtered = persons.stream()
				.filter(p -> p.name.startsWith("M"))
				.collect(Collectors.toList());

		System.out.println(filtered); // Mike and Matt

		// Creates a map for each using the key Person age and the value of a
		// Person object.
		Map<Integer, List<Person>> personsByAge = persons.stream().collect(
				Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age,
				p));

		// Gets the average age for each Person object's age.
		Double averageAge = persons.stream().collect(
				Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge); // 19.0

		// Gets the age sum for each Person object using IntSummaryStatistic
		// Object
		IntSummaryStatistics ageSummary = persons.stream().collect(
				Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);

		// Gets the age average for each Person object using IntSummaryStatistic
		// Object
		IntSummaryStatistics ageAverage = persons.stream().collect(
				Collectors.summarizingInt(p -> p.age));

		System.out.println(ageAverage);

		List<Person> persons1 = Arrays.asList(new Person("Eric", 17),
				new Person("Matt", 24), new Person("John", 25), new Person(
						"Stephen", 18));

		// Use Java 8 style Comparator to sort by Person Age for Person object
		// list above.
		Comparator<Person> descPriceComp = (Person b1, Person b2) -> (int) (b2
				.getAge() - b1.getAge());
		Collections.sort(persons1, descPriceComp);
		System.out.println("\nAfter sorting by descending price:");
		System.out.println(persons1);

		// Sort by Person Name in Ascending order.
		persons1.stream().sorted(Comparator.comparing(Person::getName))
				.map(Person::getName).collect(Collectors.toList())
				.forEach(s -> System.out.println("Regular Sort forEach: " + s));
		;
		;

		// Sort by Person Name in Reverse order.
		persons1.stream().map(Person::getName)
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList())
				.forEach(s -> System.out.println("Reverse Sort forEach: " + s));
		;
		;

		// Print all Persons' name with Age >=18.
		String phrase = persons
				.stream()
				.filter(p -> p.age >= 18)
				.map(p -> p.name)
				.collect(
						Collectors.joining(" and ", "In America ",
								" are of legal age."));

		System.out.println(phrase);

		// Declares a Map for Person Age and Name. Age as key.
		Map<Integer, String> map = persons.stream().collect(
				Collectors.toMap(p -> p.age, p -> p.name,
						(name1, name2) -> name1 + ";" + name2));

		System.out.println(map);

		// print all item in a stream. Filter if the item starts with an a.
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));

		// stream a list, sort it and collect results
		Arrays.asList(2, 3, 1).stream().sorted().collect(Collectors.toList())
				.forEach(s -> System.out.println("forEach: " + s));
		;

		// a little bit shorter
		Stream.of(2, 3, 1).sorted().collect(Collectors.toList())
				.forEach(s -> System.out.println("forEach: " + s));
		;

		// slightly simplified
		IntStream.of(2, 3, 1).sorted().boxed().collect(Collectors.toList())
				.forEach(s -> System.out.println("forEach: " + s));
		;

		// Testing default Method in PersonInterface.
		Person person = new Person("Eric", 18);
		int miles = 10;
		int mileswalk = person.walk(miles);
		System.out.println("Miles walked " + mileswalk);

	}

}
