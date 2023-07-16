package cl.uchile.dcc
package gwent

import gwent.cards.Card
import gwent.observer.Subject

import cl.uchile.dcc.gwent.board.{WeatherZone, Zone}

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
             private var _hand: List[Card]) extends Subject[String]{

  var zone: Option[Zone] = null
  var weatherZone: Option[WeatherZone] = null

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

/** Player choose a card from the deck.
 *
 * If are more than one of the same card, the first card in the list is choosed.
 *
 * @return the card that was chosen from the hand.
 *
 * */
  def chooseCard(c: Card): Option[Card] = {
    val card = hand.find(_ == c)
    if (card.isDefined) {
      val _card = card.get
      val (before, after) = hand.span(_ != _card)
      _hand = before ::: after.drop(1)
    }
    card
  }


  /** Player plays a cards in the board.
   *
   * The player plays a card. If the card exists in their hand,
   * it is played in the corresponding zone based on the type of the card.
   * This behavior was implemented using double dispatch.
   *
   * Note: if the card doesn't exist is not played. If exist two cards with the same name,
   * the leftmost card in the list representing the hand is played.
  */
  def playCard(c: Card): Unit = {
    val card: Option[Card] = chooseCard(c)
    if (card.isDefined) {
      val _card = card.get
      if (zone.isDefined) {
        val _zone = zone.get
        _zone.closecombatZone.putCloseCombatCard(_card)
        _zone.siegeZone.putSiegeCard(_card)
        _zone.rangedZone.putRangedCard(_card)
      }
      if (weatherZone.isDefined) {
        val _weatherZone = weatherZone.get
        _weatherZone.putWeatherCard(_card)

      }
    }
  }

  /** Causes the player's gem counter to be reduced by one if it is greater than 0.
   * If the gem counter is already zero, return an error.
   */
  def lostGem(): Unit = {
    if (gemCounter > 0) {
      gemCounter -= 1
      if (gemCounter == 0) {
        println("Player "+ _name+" loose the game")
        notifyObservers(_name)
      }
    } else {
      println("The gems counter can't be negative")
    }
  }


  /** Method that assigns an area of the board where the player can play his Unit Cards. */
  def assignZone(z: Zone): Unit = {
    zone = Some(z)
  }

  def assignWeatherZone(w: WeatherZone): Unit = {
    weatherZone = Some(w)
  }


}
