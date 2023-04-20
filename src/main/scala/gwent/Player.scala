package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

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
