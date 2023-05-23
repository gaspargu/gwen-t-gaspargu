package cl.uchile.dcc
package gwent.cards

import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

class SiegeCombatCard(name: String, description: String, power: Int)
  extends AbstractUnitCard(name, description, power) {

  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}
  
  override def putInSiegeZone(zone: SiegeZone): Unit = zone.addCard(this)

  override def putInRangedZone(zone: RangedZone): Unit = {}

  override def putInWeatherzone(zone: WeatherZone): Unit = {}
  
  
}
