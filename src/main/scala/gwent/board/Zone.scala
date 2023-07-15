package cl.uchile.dcc
package gwent.board

import gwent.Player

class Zone() {
  val closecombatZone: CloseCombatZone = new CloseCombatZone()
  val rangedZone: RangedZone = new RangedZone()
  val siegeZone: SiegeZone = new SiegeZone()
}
