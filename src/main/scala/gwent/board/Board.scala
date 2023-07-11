package cl.uchile.dcc
package gwent.board

import gwent.*

import cl.uchile.dcc.gwent.cards.Card

/** Class representing a board in the Gwen't game.
 *
 * A board has two players, a weather zone common for both player and two combat zones, one for each player.
 *
 *
 * @constructor Create a new board for the game with a specified player 1 and player 2.
 * @param player1 The player 1 destined for zone 1.
 * @param player2 The player 2 destined for zone 2.
 *
 */

class Board(player1: Player, player2: Player) {

  /** Combat zone of the player 1. */
  val zone1: Zone = new Zone(player1)

  /** Combat zone of the player 2. */
  val zone2: Zone = new Zone(player2)

  /** Zone where the weather cards can be played. */
  val weatherZone: WeatherZone = new WeatherZone()

  /** Player 1 plays a cards in the board.
   *
   * The player plays a card by its name. If the card exists in their hand,
   * it is played in the corresponding zone based on the type of the card.
   * This behavior was implemented using double dispatch.
   *
   * Note: if the card doesn't exist is not played. If exist two cards with the same name,
   * the leftmost card in the list representing the hand is played.
   *
   * @param nameCard The name of the card to be played.
   */
  def player1PlayCard(c: Card): Unit = {
    val undefinedCard = player1.playCard(c)
    if (undefinedCard.isDefined) {
      val card = undefinedCard.get
      zone1.closecombatZone.putCloseCombatCard(card)
      zone1.siegeZone.putSiegeCard(card)
      zone1.rangedZone.putRangedCard(card)
      weatherZone.putWeatherCard(card)
    }
    
  }

/** Player 2 plays a cards in the board.
 *
 * Note: Same rules that player 1.
 *
 * @param nameCard The name of the card to be played.
 * */
  def player2PlayCard(c: Card): Unit = {
    val undefinedCard = player2.playCard(c)
    if (undefinedCard.isDefined) {
      val card = undefinedCard.get
      zone2.closecombatZone.putCloseCombatCard(card)
      zone2.siegeZone.putSiegeCard(card)
      zone2.rangedZone.putRangedCard(card)
      weatherZone.putWeatherCard(card)
    }
    
  }
}
