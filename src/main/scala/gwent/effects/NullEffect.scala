package cl.uchile.dcc
package gwent.effects

import gwent.observer.{ISubject, Observer}

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card}

class NullEffect extends Effect {
  override def apply(self: Card, target: AbstractUnitCard): Unit = {
    // do nothing
  }
}
