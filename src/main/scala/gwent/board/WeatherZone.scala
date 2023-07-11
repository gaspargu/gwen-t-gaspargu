package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, WeatherCard}
/** Common zone for both players, where only one weather type card can be active. */
class WeatherZone {
  private var card: WeatherCard = null
  
  def addCard(otherCard: WeatherCard): Unit = card = otherCard
  
  def putWeatherCard(card: Card): Unit = card.putInWeatherzone(this)

  def show: WeatherCard = card
}
