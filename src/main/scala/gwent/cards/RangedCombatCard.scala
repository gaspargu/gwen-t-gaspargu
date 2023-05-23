package cl.uchile.dcc
package gwent.cards
import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

class RangedCombatCard(name: String, description: String, power: Int)
  extends AbstractUnitCard(name, description, power) {

  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}

  override def putInSiegeZone(zone: SiegeZone): Unit = {}

  override def putInRangedZone(zone: RangedZone): Unit = zone.addCard(this)

  override def putInWeatherzone(zone: WeatherZone): Unit = {}
}
