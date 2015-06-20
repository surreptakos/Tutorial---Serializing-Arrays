import java.io.Serializable;

/* Serializing an object means turning the object
 * into binary data. Deserializing is the opposite.
 * 
 *  In this example, we will serialize objects to a file
 *  and then deserialize them.
 */

// The only thing you need to do to make a class serializable 
// is make it implement the Serializable interface

public class Person implements Serializable {

	/**
	 * This is an ID to make sure you're deserializing the right class that you
	 * previously serialized
	 */
	private static final long serialVersionUID = 4801633306273802062L;

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
