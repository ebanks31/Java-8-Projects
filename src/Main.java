package com.ebanks.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hibernate.mapping.Set;



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
	

		// Sort by Person Name in Reverse order.
		persons1.stream().map(Person::getName)
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList())
				.forEach(s -> System.out.println("Reverse Sort forEach: " + s));
		

		// Print all Persons' name with Age >=18. Collection joining method applies a function to each item list.
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

		// Handling Mult-threading in Java 7
		Thread thread1 = new Thread(new Runnable() {
		    @Override
		    public void run(){
		        System.out.println("Task #1 is running");
		    }
		});
		
		// Handling Mult-threading in Java 8
		Runnable r = ( ) -> System.out.println( "run run run" );
		Thread t = new Thread( r );
		t.start();
		

		
		// Lambda Runnable
		Runnable task2 = () -> { System.out.println("Task #2 is running"); };
		 
		// start the thread
		new Thread(task2).start();
		 
		thread1.start();
		
		// Using Predicate to pass a function as a parameter. Predicate is a functional interface with one method called test method.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        
        System.out.println("Print all numbers:");
        evaluate(list, (n)-> true);
 
        System.out.println("Print no numbers:");
        evaluate(list, (n)-> false);
 
        System.out.println("Print even numbers:");
        evaluate(list, (n)-> n % 2 == 0 );
 
        System.out.println("Print odd numbers:");
        evaluate(list, (n)-> n % 2 == 1 );
 
        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n)-> n > 5 );
        
        
        
        // Get count, min, max, sum, and average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        
        
        // Create List of square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
        
        // Create List all distinct numbers with sort
        List<Integer> numbers1 = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct1 = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers1, distinct1);
        
        
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream().filter(x -> x.isEmpty()).count();
        // Count String with length more than 3
        long num = strList.stream().filter(x -> x.length()> 3).count();
        System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);
     
     
        // Count number of String which startswith "a"
        count = strList.stream().filter(x -> x.startsWith("a")).count();
        System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);
     
        
        // Convert String to Uppercase and join them using comma
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
        
        
        // Parallel Stream
        List<Integer> integerList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        int sum = integerList
          .parallelStream()
          .filter(i -> i % 2 == 0)
          .mapToInt(i -> i)
          .sum();

        // Will print 20
        System.out.println(sum);
        
        // Parallel Stream
        List<Integer> integerList2 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        integerList2.parallelStream().forEach(i -> System.out.print(i + " "));
        
        // Reduction
        List<Integer> integerList1 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        Map<Integer, List<Integer>> evenOddMap = integerList1
            .stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? 0 : 1));

        // Will print 2, 4, 6, 8
        System.out.println(evenOddMap.get(0));

        // Will print 1, 3, 5, 7, 9
        System.out.println(evenOddMap.get(1));
        
        
        // Parallel processing using a stateful lambda expression
        List<Integer> integerList4 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        List<Integer> resultingIntegerList = Collections.synchronizedList(new ArrayList<>());
        integerList4.parallelStream().map(i -> {
          resultingIntegerList.add(i);
          return i;
        }).forEachOrdered(i -> System.out.print(i + " "));

        
        
        int number = 9;
        // Get a list of numbers that don't divide into and a list of numbers that divide into the number above.
        List<Integer> integerList7 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        Map<Integer, List<Integer>> evenOddMap5 = integerList7
            .stream().collect(Collectors.groupingBy(i -> number % i == 0 ? 0 : 1));
        System.out.println(evenOddMap5);
        
        
        
        // Get a list of numbers that don't divide into and a list of numbers that divide into the number above.
        List<Integer> integerList8 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        List<Integer> integerList9= integerList8
          .stream()
         // .mapToInt(i -> i)
          .filter(i -> number % i == 0)
          .collect(Collectors.toList());
        System.out.println(integerList9);
        
        // Optional keyword Testing for Java 8

        String str = "";
        Optional nonEmptyOptional = Optional.of( str );

        String strNull = null;
        Optional nullableOptional = Optional.ofNullable(strNull);

        Optional<String> stringToUse = Optional.of( "optional is there" );
        
        stringToUse.ifPresent( System.out::println );

        
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        
        // Filter
        stringCollection
        .stream()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
        
        // Sorted
        stringCollection
        .stream()
        .sorted()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
        
        
        // Map
        stringCollection
        .stream()
        .map(String::toUpperCase)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);
        
        // Match
        boolean anyStartsWithA =
        	    stringCollection
        	        .stream()
        	        .anyMatch((s) -> s.startsWith("a"));

        	System.out.println(anyStartsWithA);      // true

        	boolean allStartsWithA =
        	    stringCollection
        	        .stream()
        	        .allMatch((s) -> s.startsWith("a"));

        	System.out.println(allStartsWithA);      // false

        	boolean noneStartsWithZ =
        	    stringCollection
        	        .stream()
        	        .noneMatch((s) -> s.startsWith("z"));

        	System.out.println(noneStartsWithZ);      // true
        	
        	// Count
        	long startsWithB =
        		    stringCollection
        		        .stream()
        		        .filter((s) -> s.startsWith("b"))
        		        .count();

        		System.out.println(startsWithB);    // 3
        		
        		// Reduce
        		Optional<String> reduced =
        	    stringCollection
        	        .stream()
        	        .sorted()
        	        .reduce((s1, s2) -> s1 + "#" + s2);

        	reduced.ifPresent(System.out::println);
        	
        	// Local Time in Java 8
        	LocalTime late = LocalTime.of(23, 59, 59);
        	System.out.println(late);       // 23:59:59

        	DateTimeFormatter germanFormatter =
        	    DateTimeFormatter
        	        .ofLocalizedTime(FormatStyle.SHORT)
        	        .withLocale(Locale.GERMAN);

        	LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        	System.out.println(leetTime);   // 13:37
	}


    /**
     * Evaluate list of integers based on Predicate function on given parameter.
     *
     * @param list the list
     * @param predicate the predicate
     */
    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list)  {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
    

}
