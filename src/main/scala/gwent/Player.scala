package cl.uchile.dcc
package gwent

import gwent.cards.Card

/** Class representing a player in the Gwen't game.
 *
 * Each player has a name, a gem counter, a deck of cards, and a hand of cards.
 * The deck and hand are private variables, but can be accessed via their corresponding
 * getter methods.
 * We use immutable lists instead of mutable ones to represent the deck and the hand.
 * This is a common practice in functional programming and in Scala in particular.
 * By using immutable data structures, we can avoid potential side effects caused by
 * mutable state and make our code safer and easier to reason about.
 *
 * @constructor Create a new player with a name, gem counter, deck, and hand.
 * @param _name The name of the player.
 * @param gemCounter The initial gem count for the player.
 * @param _deck The initial list of cards in the player's deck.
 * @param _hand The initial list of cards in the player's hand.
 *
 * @author ~GASPAR GUMUCIO GALLARDO~
 * @version 1.1
 * @since 1.0
 */

class Player(private val _name: String, var gemCounter: Int, private var _deck: List[Card],
             private var _hand: List[Card]) {

  /** Accessor method for the player's name */
  def name: String = _name

  /** Accessor method for the player's deck */
  def deck: List[Card] = _deck

  /** Accessor method for the player's hand */
  def hand: List[Card] = _hand

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {
      val player = obj.asInstanceOf[Player]
      (player.name == _name && player.deck == _deck && player.hand == _hand)
    } else {
      false
    }
  }

  /** Draws a card from the deck and adds it to the hand.
   *
   * The top card from the deck is removed and added to the player's hand.
   * This method also returns the drawn card.
   *
   * Note: as lists are immutable, when we "remove" a card from the deck or "add" one to
   * the hand, what we're actually doing is creating a new list with the desired contents
   * and reassigning the _deck or _hand variable to this new list.
   *
   * @return The card that was drawn from the deck.
   */
  def drawCard(): Card = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }

  /** Shuffles the player's deck.
   *
   * The order of cards in the player's deck is randomized.
   * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
   * than by modifying the original list.
   */
  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  /** The player choose a card from his hand.
   *
   * @return The card that was chosen by the player.
   */
  def playCard(name: String): Option[Card] = {
    val card = hand.find(_.name == name)
    if (card.isDefined) {
      val cardFound = card.get
      val (before, after) = hand.span(_ != cardFound)
      _hand = before ::: after.drop(1)
    }
    card
  }
  
}
