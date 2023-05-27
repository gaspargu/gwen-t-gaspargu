package cl.uchile.dcc
package gwent.cards
import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

class RangedCombatCard(name: String, description: String, power: Int)
  extends AbstractUnitCard(name, description, power) {
   def getName: String = name
   def getDescription: String = description
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[RangedCombatCard]) {
      val card = obj.asInstanceOf[RangedCombatCard]
      (card.getName == name && card.getDescription == description && card.power == power)
    } else {
      false
    }
  }

  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = {}

  override def putInSiegeZone(zone: SiegeZone): Unit = {}

  override def putInRangedZone(zone: RangedZone): Unit = zone.addCard(this)

  override def putInWeatherzone(zone: WeatherZone): Unit = {}
}
