import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObjects {

	public static void main(String args[]) {
		System.out.println("Writing objects...");

		Person[] people = { new Person(1, "Sue"), new Person(99, "Mike"),
				new Person(7, "Bob") };

		ArrayList<Person> peopleList = new ArrayList<Person>(
				Arrays.asList(people));

		// FileOutputStream is meant for writing streams of raw bytes such as
		// image data to a file

		// we use try with resources here. This will automatically close the
		// FileStream
		try (FileOutputStream fs = new FileOutputStream("people.bin");
				ObjectOutputStream os = new ObjectOutputStream(fs)) {

			os.writeObject(people);

			os.writeObject(peopleList);

			os.writeInt(peopleList.size());

			for (Person person : peopleList) {
				os.writeObject(person);
			}

			os.close();

		} catch (FileNotFoundException e) {
			// can't create file
			e.printStackTrace();
		} catch (IOException e) {
			// can't write to file
			e.printStackTrace();
		}
	}
}
