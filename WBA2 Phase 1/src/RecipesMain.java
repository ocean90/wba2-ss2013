import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import javax.xml.bind.JAXBException;


public class RecipesMain {


	/**
	 * @param args
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		RecipesController controller = null;

		try {
			controller = new RecipesController( "Aufgabe 3/3d-recipes.xml" );
		} catch (FileNotFoundException e1) {
			p( "Fehler!\n" );
			e1.printStackTrace();
			System.exit(1);
		} catch (JAXBException e1) {
			p( "Fehler!\n" );
			e1.printStackTrace();
			System.exit(1);
		}

		int input = -1;
		try {
			input = controller.request();
		} catch( InputMismatchException e ) {
			p( "Falsche Eingabe!\n" );
			System.exit(1);
		}

		switch( input ) {
			case 0:
				System.exit(1);
				break;
			case 1:
				controller.showRecipes();
				break;
		}

	}


	public static void p( Object output ) {
		System.out.println( output );
	}

}
