package cl.uchile.dcc
package gwent.board

import gwent.Player

class Zone(player: Player) {
  val closecombatZone: CloseCombatZone = new CloseCombatZone(player)
  val rangedZone: RangedZone = new RangedZone(player)
  val siegeZone: SiegeZone = new SiegeZone(player)
}
