package com.ebanks.java;
/**
 * The Class Person.
 */
class Person implements PersonInterface {
    
    /** The name. */
    String name;
    
    /** The age. */
    int age;

	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param age the age
	 */
	Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
	

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see PersonInterface#getAge()
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}