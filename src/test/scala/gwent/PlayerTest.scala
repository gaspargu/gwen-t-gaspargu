package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class PlayerTest extends munit.FunSuite{
  var carta1: Card = null
  var carta2: Card = null
  var carta3: Card = null
  var carta4: Card = null
  var carta5: Card = null
  var carta6: Card = null
  var carta7: Card = null
  var carta8: Card = null
  var mazopepe: Deck = null
  var manopepe: Hand = null
  var mazojaime: Deck = null
  var manojaime: Hand = null
  var jugadorPepe: Player = null
  var jugadorJaime: Player = null
  var jugador_falso: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new Card("1")
    carta2 = new Card("2")
    carta3 = new Card("3")
    carta4 = new Card("4")
    carta5 = new Card("5")
    carta6 = new Card("6")
    carta7 = new Card("7")
    carta8 = new Card("8")
    mazopepe = new Deck(ListBuffer(carta1,carta2,carta3))
    manopepe = new Hand(ListBuffer(carta4))
    mazojaime = new Deck(ListBuffer(carta5, carta6, carta7))
    manojaime = new Hand(ListBuffer(carta8))
    jugadorPepe = new Player("Pepe", true, 2, mazopepe, manopepe)
    jugadorJaime = new Player("Jaime", false, 2, mazojaime, manojaime)

  }

  test("equals") {
    assertEquals(jugadorPepe, new Player("Pepe", true, 2,
      new Deck(ListBuffer(new Card("1"),new Card("2"),new Card("3"))),
      new Hand(ListBuffer(new Card("4")))))
    assertNotEquals(jugadorPepe,jugadorJaime)
  }

  test("draw a card from the deck") {
    jugadorPepe.drawCard()
    assertEquals(jugadorPepe, Player("Pepe", true, 2,
      new Deck(ListBuffer(new Card("2"),new Card("3"))),
      new Hand(ListBuffer(new Card("4"),new Card("1")))))
    jugadorPepe.drawCard()
    assertEquals(jugadorPepe, Player("Pepe", true, 2,
      new Deck(ListBuffer(new Card("3"))),
      new Hand(ListBuffer(new Card("4"), new Card("1"), new Card("2")))))
  }

  test("play a card from the hand") {
    assertEquals(jugadorJaime.playCard("8"), Some(carta8))
    assertEquals(jugadorJaime, new Player("Jaime",false,2,
      new Deck(ListBuffer(new Card("5"),new Card("6"),new Card("7"))),
      new Hand(ListBuffer())))
  }

  test("not equals with null player") {
    assertNotEquals(jugadorJaime, jugador_falso)
  }
}
