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
  val zone1: Zone = new Zone()
  
  player1.assignZone(zone1)

  /** Combat zone of the player 2. */
  val zone2: Zone = new Zone()
  
  player2.assignZone(zone2)

  /** Zone where the weather cards can be played. */
  val weatherZone: WeatherZone = new WeatherZone()
  
  player1.assignWeatherZone(weatherZone)
  player2.assignWeatherZone(weatherZone)

  /** Player plays a cards in the board.
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
  
  
  
}
