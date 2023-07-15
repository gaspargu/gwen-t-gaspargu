package cl.uchile.dcc
package gwent.effects

import gwent.cards.{AbstractUnitCard, Card}

import cl.uchile.dcc.gwent.observer.{ISubject, Observer}

class MoraleBoost extends Effect {
  override def apply(self: Card, target: AbstractUnitCard): Unit = {
    target.setCurrentPower(target.getCurrentPower + 1)
  }
}
