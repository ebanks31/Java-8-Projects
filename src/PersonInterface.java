package com.ebanks.java;

/**
 * The Interface PersonInterface. Functional interface must have only one abstract method 
 * but can have any number of default methods.
 */
@FunctionalInterface
public interface PersonInterface {

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	int getAge();
	
	/**
	 * Walk. This method is a default method for this interface.
	 * Fully functional method are allowed in interfaces in Java 8.
	 *
	 * @param miles the miles
	 * @return the int miles that were walked.
	 */
	default int walk(int miles)
	{
		return miles;
	}
}
