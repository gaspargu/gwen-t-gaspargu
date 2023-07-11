package cl.uchile.dcc
package gwent.cards
import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

import cl.uchile.dcc.gwent.effects.WeatherEffect

class WeatherCard(private val _name: String, private val _description: String, 
                  private val _effect: WeatherEffect) extends Card {
  override def name: String = _name
  override def description: String = _description

  override def toString: String = {
    "WeatherCard("+name+", "+description+")"
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val card = obj.asInstanceOf[WeatherCard]
      (card.name == _name && card.description == _description)
    } else {
      false
    }
  }
    
  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}

  override def putInSiegeZone(zone: SiegeZone): Unit = {}

  override def putInRangedZone(zone: RangedZone): Unit = {}

  override def putInWeatherzone(zone: WeatherZone): Unit = zone.addCard(this)
}
