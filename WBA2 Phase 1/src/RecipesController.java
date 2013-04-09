import java.io.FileInputStream;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileNotFoundException;
import xsdobjects.*;


public class RecipesController {
	private static Scanner in;

	private Unmarshaller unMarshaller;
	private Marshaller marshaller;
	private Recipe recipe;

	public RecipesController( String file ) throws JAXBException, FileNotFoundException {
		in = new Scanner( System.in );

		JAXBContext jaxbContext = JAXBContext.newInstance( Recipe.class );

		this.unMarshaller = jaxbContext.createUnmarshaller(); // Reading
		this.marshaller   = jaxbContext.createMarshaller(); // Writing

		this.recipe = (Recipe) unMarshaller.unmarshal( new FileInputStream( file ) );
	}

	public int request() {
		System.out.println( "Rezepte von Chefkoch.de" );
		System.out.println( "=======================" );
		System.out.println();
		System.out.println( "Bitte wählen Sie aus:" );
		System.out.println( "\t0 - Beenden" );
		System.out.println( "\t1 - Rezepte anzeigen" );

		System.out.print( "Eingabe: " );
		return in.nextInt();
	}

	public void showRecipes() {
		System.out.print( "Eingabe: " );
	}

}
