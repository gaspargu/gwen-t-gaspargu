package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class Hand(private var hand: ListBuffer[Card]) {
  override def toString: String = s"Hand(hand=$hand)"

  def getHand(): ListBuffer[Card] = hand
  
  def chooseCard(name: String): Unit = {

  }

  def addCard(card: Card): Unit = {
    hand += card
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Hand]) {
      val other_hand = other.asInstanceOf[Hand]
      hand == other_hand.getHand()
    } else {
      false
    }
  }
}
