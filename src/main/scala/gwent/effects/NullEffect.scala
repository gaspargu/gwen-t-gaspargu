package cl.uchile.dcc
package gwent.effects

import gwent.observer.{ISubject, Observer}

class NullEffect[Int] extends CombatEffect with Observer[Int]{
  override def update(o: ISubject[Int], arg: Int): Unit = ???
}
