
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
	 * Walk.
	 *
	 * @param miles the miles
	 * @return the int miles that were walked.
	 */
	default int walk(int miles)
	{
		return miles;
	}
}
