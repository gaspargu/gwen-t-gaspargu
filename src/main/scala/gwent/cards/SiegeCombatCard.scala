package cl.uchile.dcc
package gwent.cards

import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

class SiegeCombatCard(private val _name: String, private val _description: String, private val _power: Int)
  extends AbstractUnitCard(_name, _description, _power) {
  def name: String = name
  def description: String = description

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[SiegeCombatCard]) {
      val card = obj.asInstanceOf[SiegeCombatCard]
      (card.name == name && card.description == description && card.power == _power)
    } else {
      false
    }
  }

  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}
  
  override def putInSiegeZone(zone: SiegeZone): Unit = zone.addCard(this)

  override def putInRangedZone(zone: RangedZone): Unit = {}

  override def putInWeatherzone(zone: WeatherZone): Unit = {}
  
  
  
}
