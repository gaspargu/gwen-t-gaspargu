package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

/** A class representing a player.
 *
 * The player is defined by its name, the section of the board where it is located,
 * the number of gems that have, his deck and his hand of cards.
 *
 * @param name The name of the player.
 * @param section The section of the board where is the player.
 * @param gems The number of gems of the player.
 * @param deck The deck of the player.
 * @param hand The hand of the player.
 *
 *
 * @constructor Creates a new player with the specified name, section, gems, deck and hand.
 *
 * @example
 * {{{
 * val card = new Card("Dark Dragon")
 * val name = card.getName()
 * println(s"The name of the card is $name")
 * }}}
 *
 */

class Player(name: String, section: Boolean, gems: Int, deck: Deck, hand: Hand) {
  def getName(): String = name
  
  def getDeck(): Deck = deck
  
  def getHand(): Hand = hand
  def drawCard(): Unit = {
    val drawn_card: Option[Card] = deck.draw()
    if (drawn_card.isDefined) {
      hand.addCard(drawn_card.get)
    }
  }
  
  def playCard(name: String): Option[Card] = {
    hand.chooseCard(name)
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Player]) {
      val other_player = other.asInstanceOf[Player]
      name == other_player.getName() && deck == other_player.getDeck() &&
        hand == other_player.getHand()
    } else {
      false
    }
  }

}
