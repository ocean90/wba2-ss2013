import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.*;

import xsdobjects.*;

public class RecipesMain {

	private static Scanner in;

	/**
	 * @param args
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		in = new Scanner( System.in );

		JAXBContext jaxbContext = JAXBContext.newInstance( Recipe.class );

		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
		Recipe recipe = (Recipe) unMarshaller.unmarshal( new FileInputStream( "Aufgabe 3/3d-recipe.xml" ) );

		System.out.println( recipe.getTitle() );

	}

}
