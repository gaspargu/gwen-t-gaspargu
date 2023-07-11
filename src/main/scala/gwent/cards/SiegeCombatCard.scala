package cl.uchile.dcc
package gwent.cards

import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

import cl.uchile.dcc.gwent.effects.CombatEffect

class SiegeCombatCard(private val _name: String, private val _description: String, private val _power: Int,
                      private val _effect: CombatEffect)
  extends AbstractUnitCard(_name, _description, _power, _effect) {
  def name: String = _name
  def description: String = _description

  override def toString: String = {
    "SiegeCombatCard(" + name + ", " + description + ", " + _power.toString + ")"
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[SiegeCombatCard]) {
      val card = obj.asInstanceOf[SiegeCombatCard]
      (card.name == _name && card.description == _description && card.currentPower == this.currentPower)
    } else {
      false
    }
  }

  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}
  
  override def putInSiegeZone(zone: SiegeZone): Unit = zone.addCard(this)

  override def putInRangedZone(zone: RangedZone): Unit = {}

  override def putInWeatherzone(zone: WeatherZone): Unit = {}
  
  
  
}
