package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer


class DeckTest extends munit.FunSuite {
  var carta1: Card = null
  var carta2: Card = null
  var carta3: Card = null
  var carta4: Card = null
  var mazo: Deck = null
  var mazo_vacio: Deck = null

  override def beforeEach(context: BeforeEach): Unit = {

    carta1 = new Card("1")
    carta2 = new Card("2")
    carta3 = new Card("3")
    carta4 = new Card("4")
    mazo = new Deck(ListBuffer(carta1, carta2, carta3, carta4))
    mazo_vacio = new Deck(ListBuffer())

  }

  test("equal") {
    assertEquals(mazo, new Deck(ListBuffer(new Card("1"), new Card("2"),
      new Card("3"),new Card("4"))))
    assertNotEquals(mazo, new Deck(ListBuffer(new Card("1"))))
  }

  test("draw card from the deck") {
    assertEquals(mazo.draw(),Some(carta1))
    assertEquals(mazo, new Deck(ListBuffer(new Card("2"), new Card("3"),new Card("4"))))
    assertEquals(mazo.draw(),Some(carta2))
    assertEquals(mazo, new Deck(ListBuffer(new Card("3"),new Card("4"))))
  }

  test("exception: empty deck") {
    assertEquals(mazo_vacio.draw(),None)
  }

}