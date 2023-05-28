package cl.uchile.dcc
package gwent

import gwent.cards.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object Main {
  def main(args: Array[String]): Unit = {
    val carta1: CloseCombatCard = new CloseCombatCard("carta1", "", 2)
    val carta2: CloseCombatCard = new CloseCombatCard("carta2", "", 3)
    val carta3: SiegeCombatCard = new SiegeCombatCard("carta3", "", 3)
    val carta4: SiegeCombatCard = new SiegeCombatCard("carta4", "", 3)
    val carta5: RangedCombatCard = new RangedCombatCard("carta5", "", 2)
    val carta6: RangedCombatCard = new RangedCombatCard("carta6", "", 6)
    val carta7: WeatherCard = new WeatherCard("rain", "")
    val carta8: WeatherCard = new WeatherCard("snow", "")
    val jugador1 = new Player("Jugador 1", 3, List(carta1, carta2), List(carta3, carta4))
    val jugador2 = new Player("Jugador 2", 3, List(carta5, carta6), List(carta7, carta8))
    println(jugador1.hand)
    jugador1.playCard("carta3")
    println(jugador1.hand)
  }

}
