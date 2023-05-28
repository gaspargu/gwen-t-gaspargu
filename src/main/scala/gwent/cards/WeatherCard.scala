package cl.uchile.dcc
package gwent.cards
import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

class WeatherCard(private val _name: String, private val _description: String) extends Card {
  override def name: String = _name
  override def description: String = _description
  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}

  override def putInSiegeZone(zone: SiegeZone): Unit = {}

  override def putInRangedZone(zone: RangedZone): Unit = {}

  override def putInWeatherzone(zone: WeatherZone): Unit = zone.addCard(this)
}
