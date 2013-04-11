import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import jaxbObjects.*;

/**
 * Controlls the output of one or more recipe/recipes.
 *
 * @author Dominik Schilling
 */
public class RecipesController {

	private static final Scanner in = new Scanner( System.in );

	private Unmarshaller unMarshaller;
	private Marshaller marshaller;
	private Recipes recipes;

	private static final String RECIPES_XML_OUTPUT = "misc/Aufgabe 4/4c-recipes.xml";

	/**
	 * Constructor
	 *
	 * @param file The original XML file which includes recipes.
	 *
	 * @throws Exception
	 */
	public RecipesController( String file ) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance( Recipes.class );

		this.unMarshaller = jaxbContext.createUnmarshaller(); // Reading
		this.marshaller   = jaxbContext.createMarshaller(); // Writing
		this.recipes = (Recipes) unMarshaller.unmarshal( new File( file ) );
	}

	/**
	 * Returns a list of recipes.
	 *
	 * @return List of recipes
	 */
	public List<Recipe> getRecipes() {
		return this.recipes.getRecipe();
	}

	/**
	 * Returns a raw recipe.
	 *
	 * @return Raw recipe object
	 */
	public Recipe getRecipe( int id ) {
		if ( ! this.isValidID( id ) )
			return null;

		return this.recipes.getRecipe().get( id );
	}


	/**
	 * Prints names of saved recipes.
	 */
	public void showRecipes() {
		List<Recipe> recipes = (List<Recipe>) this.recipes.getRecipe();

		System.out.println( "\nGespeicherte Rezepte:" );

		int i = 1;
		for ( Recipe recipe : recipes )
			System.out.println( "\t" + i++ + " - " + recipe.getTitle());
	}

	/**
	 * Prints a recipe.
	 *
	 * @param id ID of a recipe
	 */
	public void showRecipe( int id ) {
		if ( ! this.isValidID( id ) )
			return;

		Recipe recipe = this.getRecipe( id );

		System.out.println();

		// Category
		if ( null != recipe.getCategory() )
			System.out.println( "» " + recipe.getCategory().getName() );

		// Title
		System.out.println( recipe.getTitle() );
		for ( int i = 0; i < recipe.getTitle().length(); i++ )
			System.out.print( "=" );

		// Subtitle
		if ( null != recipe.getSubtitle() )
			System.out.println( recipe.getSubtitle() );

		// Images
		this.showImages( recipe );

		// Ingredients
		this.showIngredients( recipe );

		// Direction
		this.showDirection( recipe );

		// Comments
		this.showComments( recipe );
	}

	/**
	 * Prints the images of a recipse.
	 *
	 * @param recipe The recipe
	 */
	private void showImages( Recipe recipe ) {
		if ( null == recipe.getImages() || recipe.getImages().getImage().size() == 0 )
			return;

		System.out.println();

		List<Image> images = (List<Image>) recipe.getImages().getImage();
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

	/**
	 * Prints the ingredients.
	 *
	 * @param recipe The recipe
	 */
	private void showIngredients( Recipe recipe ) {
		if ( null == recipe.getIngredients() )
			return;

		System.out.println();

		List<Ingredients> _ingredients = recipe.getIngredients();
		Ingredients ingredients = _ingredients.get(0);

		System.out.println( "Zutaten für " + ingredients.getPortions() + " Portionen" );
		System.out.print( "----------------------" );
		for ( int i = 0; i < ingredients.getPortions().toString().length(); i++ )
			System.out.print( "-" );
		System.out.println();

		for ( Ingredient ingredient : ingredients.getIngredient() ) {
			String amount = ingredient.getAmount();
			String unit = ingredient.getUnit();
			String name = ingredient.getName();

			amount = ( null != amount ) ? amount : "";

			System.out.printf(
				"%s %s\t%s\n",
				amount,
				unit,
				name
			);
		}
	}

	/**
	 * Prints the direction of a recipe.
	 *
	 * @param recipe The recipe
	 */
	private void showDirection( Recipe recipe ) {
		if ( null == recipe.getDirection() )
			return;

		System.out.println();

		System.out.println( "Zubereitung" );
		System.out.println( "-----------" );
		if ( null != recipe.getDirection().getSeverity() ) {
			System.out.println( "Schwierigkeitsgrad: " + recipe.getDirection().getSeverity());
		}

		if ( null != recipe.getDirection().getCalories() ) {
			System.out.println( "Kalorien: " + recipe.getDirection().getCalories() + " kcal");
		}

		if ( null != recipe.getDirection().getTimes() ) {
			if ( null != recipe.getDirection().getTimes().getPre() )
				System.out.println( "Vorbereitungszeit: " + recipe.getDirection().getTimes().getPre() + " Minuten" );

			if ( null != recipe.getDirection().getTimes().getCook() )
				System.out.println( "Koch-/Backzeit: " + recipe.getDirection().getTimes().getCook() + " Minuten" );

			if ( null != recipe.getDirection().getTimes().getRest() )
				System.out.println( "Ruhezeit: " + recipe.getDirection().getTimes().getRest() + " Minuten" );
		}

		List<Steps> _steps = (List<Steps>) recipe.getDirection().getSteps();
		Steps steps = _steps.get(0);

		System.out.println();
		for ( String step : steps.getStep() ) {
			System.out.println( step );
		}

	}

	/**
	 * Prints comments of a recipe
	 *
	 * @param recipe The recipe
	 */
	private void showComments( Recipe recipe ) {
		if ( null == recipe.getComments() )
			return;

		System.out.println();

		List<Comments> _comments = recipe.getComments();
		Comments comments = _comments.get(0);

		System.out.println( "Kommentare" );
		System.out.println( "----------" );

		for ( Comment comment : comments.getComment() ) {
			Date date = comment.getDate().toGregorianCalendar().getTime();

			System.out.println( comment.getCommentAuthor().getName() + " schrieb am " +  new SimpleDateFormat( "dd.MM.yy HH:mm").format( date ) + ":" );
			System.out.println( comment.getContent() );
			System.out.println();
		}
	}

	/**
	 * Adds a comment to a recipe
	 *
	 * @param id ID of a recipe
	 */
	public void commentRecipe( int id ) {
		if ( ! this.isValidID( id ) )
			return;

		Recipe recipe = this.getRecipe( id );

		System.out.println();

		System.out.println( "Rezept \"" + recipe.getTitle() + "\" kommentieren" );
		System.out.print( "----------------------" );
		for ( int i = 0; i < recipe.getTitle().length(); i++ )
			System.out.print( "-" );
		System.out.println();

		Comment comment = new ObjectFactory().createComment();

		System.out.print( "Ihr Name: " );
		String name = in.nextLine();
		CommentAuthor commentAuthor = new ObjectFactory().createCommentAuthor();
		commentAuthor.setName( name );
		comment.setCommentAuthor( commentAuthor );

		System.out.println();

		System.out.print( "Ihr Kommentar: " );
		String text = in.nextLine();
		comment.setContent( text );

		XMLGregorianCalendar date = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar( new GregorianCalendar() );
		} catch ( DatatypeConfigurationException e ) {
			e.printStackTrace();
		}
		comment.setDate( date );

		List<Comments> _comments = recipe.getComments();
		Comments comments = _comments.get(0);

		// Add the new comment to the recipe
		comments.getComment().add( comment );

		// Save the new recipe
		this.save();

		System.out.println( "Kommentar erfolgreich gespeichert!" );
	}

	/**
	 * Saves the new XML object
	 */
	private void save() {
		try {
			this.marshaller.marshal( this.recipes, new File( RECIPES_XML_OUTPUT ) );
		} catch ( JAXBException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if a recipe id exists.
	 *
	 * @param id The id of a recipe
	 * @return true on success, false on failure
	 */
	private boolean isValidID( int id ) {
		return ( id <= this.recipes.getRecipe().size() - 1 );
	}

}
