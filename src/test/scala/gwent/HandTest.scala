package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class HandTest extends munit.FunSuite {
  var carta1: Card = null
  var carta2: Card = null
  var carta3: Card = null
  var carta4: Card = null
  var mano: Hand = null
  var mano_vacia: Hand = null

  override def beforeEach(context: BeforeEach): Unit = {

    carta1 = new Card("1")
    carta2 = new Card("2")
    carta3 = new Card("3")
    carta4 = new Card("4")

    mano = new Hand(ListBuffer(carta1, carta2, carta3))
    mano_vacia = new Hand(ListBuffer())

  }

  test("equals") {
    assertEquals(mano, new Hand(ListBuffer(new Card("1"),new Card("2"), new Card("3"))))
  }

  test("add card to the hand") {
    mano.addCard(carta4)
    assertEquals(mano,new Hand(ListBuffer(new Card("1"), new Card("2"),
      new Card("3"), new Card("4"))))
  }

  test("choose card from the hand") {
    assertEquals(mano.chooseCard("2"), Some(carta2))
    assertEquals(mano, new Hand(ListBuffer(new Card("1"),new Card("3"))))
  }

  test("exception: the card is not found") {
    assertEquals(mano.chooseCard("bla"), None)
    assertEquals(mano, new Hand(ListBuffer(new Card("1"),new Card("2"),new Card("3"))))
  }
}
