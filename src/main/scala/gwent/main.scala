package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

@main
def main(): Unit = {
  val perrito: Card = new Card("perrito")
  val gatito: Card = new Card("gatito")
  val conejo: Card = new Card("conejo")
  val mazo_animales: Deck = new Deck(ListBuffer(perrito,gatito,conejo))
  val mano_animales: Hand = new Hand(ListBuffer(perrito,gatito))

  println(mano_animales)

}