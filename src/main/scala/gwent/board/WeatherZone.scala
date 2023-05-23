package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, WeatherCard}

class WeatherZone {
  var card: WeatherCard = null
  
  def addCard(otherCard: WeatherCard): Unit = card = otherCard
  
  def putWeatherCard(card: Card): Unit = card.putInWeatherzone(this)
}
