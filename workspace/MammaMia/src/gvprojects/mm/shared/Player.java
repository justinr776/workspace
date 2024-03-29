package gvprojects.mm.shared;

import gvprojects.mm.model.ICard;
import gvprojects.mm.model.IRecipeCard;
import gvprojects.mm.model.IToppingCard;
import gvprojects.mm.view.CardImageFactory;
import gvprojects.mm.view.MyCard;
import gvprojects.mm.view.RecipeImage;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Player Class that holds a players specific topping, hand of cards, and a
 * boolean if they have played.
 * 
 * @author rohrj
 * @version April 12, 2013
 */
public class Player {
	private Topping topping;
	private Stack<IRecipeCard> orders;
	private Stack<ICard> hand;
	private boolean played;
	private int pID;

	/**
	 * Returns whether the player has played or not
	 * 
	 * @return true or false, if the player has played
	 */
	public boolean isPlayed() {
		return played;
	}

	/**
	 * This method builds the player's recipe pile. It does this by using the
	 * CardImageFactory class to get the images and topping combinations. Then
	 * for each string topping set, it creates a new MyCard and then uses that
	 * to make a Recipe Card with the MyCards image.
	 * 
	 */
	private void buildRecipiePile() {
		int i = 0;
		// Get the images
		List<RecipeImage>[] imageSet = CardImageFactory.createRecipeCards();
		// Get the recipe string using this Players topping
		Set<String> oneSet = RecipeFactory.generateSet(topping);
		// For each string make a card, then use that for the recipe card
		for (String s : oneSet) {
			MyCard c = new MyCard(imageSet[pID].get(i).getImage(), null);
			orders.add(new RecipeCard(s, topping, c));
			i++;
		}
	}

	/**
	 * Sets the played boolean to the provided parameter
	 * 
	 * @param played
	 *            the boolean true or false, if they have played
	 */
	public void setPlayed(boolean played) {
		this.played = played;
	}

	/**
	 * Constructor that takes a topping that is special to this player and the
	 * player ID of the player. Makes the the order/recipe stack and builds the
	 * pile of Recipes for the player
	 * 
	 * @param p
	 *            the special topping for this player
	 * @param pID
	 *            the player id to use
	 */
	public Player(Topping p, int pID) {
		topping = p;
		orders = new Stack<IRecipeCard>();
		hand = new Stack<ICard>();
		played = false;
		this.pID = pID;
		buildRecipiePile();
	}

	/**
	 * Returns this players special topping
	 * 
	 * @return the topping of this player
	 */
	public Topping getTopping() {
		return topping;
	}

	/**
	 * Adds the given recipe card to the bottom of the stack
	 * 
	 * @param card
	 *            the recipe card to add
	 */
	public void setRecipeCards(IRecipeCard card) {
		orders.add(0, card);
	}

	/**
	 * Returns this players stack of recipe cards
	 * 
	 * @return the stack of this players orders
	 */
	public Stack<IRecipeCard> getRecipes() {
		return orders;
	}

	/**
	 * Returns the Players hand of ICard
	 * 
	 * @return the stack of ICard's in hand
	 */
	public Stack<ICard> getHand() {
		return hand;
	}

	/**
	 * Puts the given ICard onto the players hand
	 * 
	 * @param card
	 *            the card to add to the hand stack
	 */
	public void setHandCards(ICard card) {
		hand.push(card);
	}
}
