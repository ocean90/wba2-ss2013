package de.fhkoeln.wba2.phase1.aufgabe4;

import java.util.Scanner;

/**
 * Program to print and comment recipes
 *
 * @author Dominik Schilling
 */
public class RecipesMain {

	private static final Scanner in = new Scanner( System.in );

	private static RecipesController controller = null;

	private static boolean _firstRun = true;

	private static final String RECIPES_XML = "misc/Aufgabe 4/4c-recipes.xml";

	/**
	 * Main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Controller instance
		try {
			controller = new RecipesController( RECIPES_XML );
		} catch (Exception e1) {
			System.err.println( "Fehler!\n" );
			e1.printStackTrace();
			System.exit(1);
		}

		// Print and handle user input
		int input = -1;
		do {
			input = request();
			handleRequest( input );
		} while( 0 != input );

	}

	/**
	 * Prints the user request form.
	 *
	 * @return User input
	 */
	public static int request() {

		if ( _firstRun ) {
			System.out.println( "Rezepte von Chefkoch.de" );
			System.out.println( "=======================" );
			_firstRun = false;
		}
		System.out.println();
		System.out.println( "Bitte wählen Sie aus:" );
		System.out.println( "\t1 - Rezeptübersicht anzeigen" );
		System.out.println( "\t2 - Rezept anzeigen" );
		System.out.println( "\t3 - Rezept kommentieren" );
		System.out.println( "\t0 - Beenden" );

		System.out.print( "Eingabe: " );
		return in.nextInt();
	}

	/**
	 * Handles user input
	 *
	 * @param id User input
	 */
	private static void handleRequest( int id ) {
		boolean success;

		switch( id ) {
			// Exit
			case 0:
				System.out.println( "\nProgramm wurde beendet." );
				break;
			// List recipes
			case 1:
				controller.showRecipes();
				break;
			// Print recipe
			case 2:
				success = false;
				do {
					System.out.print( "Rezeptnummer eingeben: " );
					int rezeptNummer = in.nextInt() - 1;

					if ( rezeptNummer < 0 || rezeptNummer > controller.getRecipes().size() ) {
						System.out.println();
						System.err.println( "Rezept nicht vorhanden." );
						success = false;
					} else {
						controller.showRecipe( rezeptNummer );
						success = true;
					}
				} while ( ! success );
				break;
			// Comment recipe
			case 3:
				success = false;
				do {
					System.out.print( "Rezeptnummer eingeben: " );
					int rezeptNummer = in.nextInt() - 1;

					if ( rezeptNummer < 0 || rezeptNummer > controller.getRecipes().size() ) {
						System.out.println();
						System.err.println( "Rezept nicht vorhanden." );
						success = false;
					} else {
						controller.commentRecipe( rezeptNummer );
						success = true;
					}
				} while ( ! success );
				break;
		}
	}
}
