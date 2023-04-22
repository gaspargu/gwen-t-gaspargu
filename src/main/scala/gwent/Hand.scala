package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

/** A class representing a hand.
 *
 * The hand is defined by a list buffer of cards.
 *
 * @param hand The list buffer of cards, representing a player's hand.
 *
 * @constructor Creates a new hand with the list of cards inside it.
 *
 * @example
 * {{{
 * val hand = new Hand(ListBuffer(new Card("Dark Dragon")))
 * hand.toString
 *
 * }}}
 *
 */

class Hand(private var hand: ListBuffer[Card]) extends AbstractListOfCards(hand) {
  override def toString: String = s"Hand(hand=$hand)"

  /** Choose a card from the hand using the name of the card.
   *
   * If there is no card with that name it returns None, if the card exist is returned and removed from the hand.
   *
   * @param name the name of the card you want to choose.
   * @return None if the card is not in the hand.
   * @return The card if the card is in the hand.
   *
   * */
  def chooseCard(name: String): Option[Card] = {
    for (i <- hand.indices) {
      if (hand(i).getName()==name) {
        return Some(hand.remove(i))
      }
    }
    println("You don't have that card")
    None
  }

  /** Add a card to the end of the list buffer. */
  def addCard(card: Card): Unit = {
    hand += card
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Hand]) {
      val other_hand = other.asInstanceOf[Hand]
      hand == other_hand.getList()
    } else {
      false
    }
  }
}
