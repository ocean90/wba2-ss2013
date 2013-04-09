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
		for ( Recipe recipe : recipes )
			System.out.println( "\t" + i++ + " - " + recipe.getTitle());

		this.showRecipe(0);
	}

	public void showRecipe( int id ) {
		if ( id > this.recipes.getRecipe().size() - 1 )
			return;

		Recipe recipe = this.recipes.getRecipe().get( id );

		System.out.println();

		if ( null != recipe.getCategory() )
			System.out.println( "» " + recipe.getCategory().getName() );

		System.out.println( recipe.getTitle() );

		for ( int i = 0; i < recipe.getTitle().length(); i++ )
			System.out.print( "=" );

		if ( null != recipe.getSubtitle() )
			System.out.println( recipe.getSubtitle() );

		this._showImages( recipe );
	}

	private void _showImages( Recipe recipe ) {
		if ( null == recipe.getImages() || recipe.getImages().getImage().size() == 0 )
			return;

		System.out.println();

		ArrayList<Image> images = (ArrayList<Image>) recipe.getImages().getImage();
		int imagesCount = images.size();
		int count = 1;
		for ( Image image : images ) {
			System.out.printf(
				"Bild %d/%d von %s (%s)\n",
				count++,
				imagesCount,
				image.getAuthor(),
				image.getSource()
			);
		}
	}

}
