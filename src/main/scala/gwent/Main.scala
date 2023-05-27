package cl.uchile.dcc
package gwent

import gwent.cards.RangedCombatCard

object Main {
  def main(args: Array[String]): Unit = {
    val ccCard: RangedCombatCard = new RangedCombatCard("ranged","bla",3)
    println(ccCard.name)
  }

}
