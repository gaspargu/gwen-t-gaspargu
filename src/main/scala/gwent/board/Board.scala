package cl.uchile.dcc
package gwent.board

import gwent.*

import cl.uchile.dcc.gwent.cards.Card

class Board(player1: Player, player2: Player) {

  val zone1: Zone = new Zone(player1)
  val zone2: Zone = new Zone(player2)

  val weatherZone: WeatherZone = new WeatherZone()

  def player1PlayCard(nameCard: String): Unit = {
    val undefinedCard = player1.playCard(nameCard)
    if (undefinedCard.isDefined) {
      val card = undefinedCard.get
      zone1.closecombatZone.putCloseCombatCard(card)
      zone1.siegeZone.putSiegeCard(card)
      zone1.rangedZone.putRangedCard(card)
      weatherZone.putWeatherCard(card)
    }
    
  }
  
  def player2PlayCard(nameCard: String): Unit = {
    val undefinedCard = player2.playCard(nameCard)
    if (undefinedCard.isDefined) {
      val card = undefinedCard.get
      zone2.closecombatZone.putCloseCombatCard(card)
      zone2.siegeZone.putSiegeCard(card)
      zone2.rangedZone.putRangedCard(card)
      weatherZone.putWeatherCard(card)
    }
    
  }
}
