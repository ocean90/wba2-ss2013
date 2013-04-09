import java.io.FileInputStream;
import java.util.ArrayList;
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
	private Recipes recipes;

	public RecipesController( String file ) throws JAXBException, FileNotFoundException {
		in = new Scanner( System.in );

		JAXBContext jaxbContext = JAXBContext.newInstance( Recipes.class );

		this.unMarshaller = jaxbContext.createUnmarshaller(); // Reading
		this.marshaller   = jaxbContext.createMarshaller(); // Writing

		this.recipes = (Recipes) unMarshaller.unmarshal( new FileInputStream( file ) );
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
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) this.recipes.getRecipe();

		System.out.println( "\nGespeicherte Rezepte:" );


		int i = 1;
		for ( Recipe recipe : recipes ) {
            System.out.println( "\t" + i++ + " - " + recipe.getTitle());
      }
	}

}
