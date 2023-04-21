package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class Deck(deck: ListBuffer[Card]) extends AbstractListOfCards(deck) {
  override def toString: String = s"Deck(deck=$deck)"

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
