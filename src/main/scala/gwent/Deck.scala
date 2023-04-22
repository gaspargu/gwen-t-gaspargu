package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

/** A class representing a deck.
 *
 * The deck is defined by a list buffer of cards.
 *
 * @param deck The list buffer of cards, representing a player's deck.
 *
 * @constructor Creates a new deck with the list of cards inside it.
 *
 * @example
 * {{{
 * val deck = new Deck(ListBuffer(new Card("Dark Dragon")))
 * deck.toString
 *
 * }}}
 *
 */

class Deck(deck: ListBuffer[Card]) extends AbstractListOfCards(deck) {
  override def toString: String = s"Deck(deck=$deck)"

  /** Draw a card from the deck.
   *
   * @return None if list buffer of card is empty and print a message that says is no card left in the deck.
   * @return The first card of the list buffer.
   *
   * */
  def draw(): Option[Card] = {
    if (deck.isEmpty) {
      println("There are no cards left in the deck")
      None
    } else {
      Some(deck.remove(0))
    }
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Deck]) {
      val other_deck = other.asInstanceOf[Deck]
      deck == other_deck.getList()
    } else {
      false
    }
  }
}
