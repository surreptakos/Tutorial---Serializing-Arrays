import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// Good for implementing a "saving" feature
public class ReadObjects {

	public static void main(String args[]) {
		System.out.println("Reading objects...");

		try (FileInputStream fi = new FileInputStream("people.bin");
				ObjectInputStream is = new ObjectInputStream(fi)) {

			Person[] people = (Person[]) is.readObject();

			// we get a warning here because ArrayList suffers from
			// type-erasure. The type of the class in the diamond brackets is
			// lost when the program is compiled. It's just there for the
			// programmer to make sure that they're doing things right.
			@SuppressWarnings("unchecked")
			ArrayList<Person> peopleList = (ArrayList<Person>) is.readObject();

			for (Person person : people) {
				System.out.println(person);
			}

			for (Person person : peopleList) {
				System.out.println(person);
			}

			int num = is.readInt();

			for (int i = 0; i < num; i++) {
				Person person = (Person) is.readObject();
				System.out.println(person);
			}

			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}