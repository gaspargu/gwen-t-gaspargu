package cl.uchile.dcc
package gwent

/** A subclass of unit card. This type of card must be played in the combat zone of close combat.  */
class CloseCombat(name: String, atk: Int) extends UnitCard(name, atk) {

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[CloseCombat]) {
      val other_card = other.asInstanceOf[CloseCombat]
      name == other_card.getName() && atk == other_card.getAttack()
    } else false
  }

}
