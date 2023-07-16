package cl.uchile.dcc
package gwent.effects

import gwent.observer.Subject

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card}

trait Effect {
  def apply(self: Card, target: AbstractUnitCard): Unit
}
