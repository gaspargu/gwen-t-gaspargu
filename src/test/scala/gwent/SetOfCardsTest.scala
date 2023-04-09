package cl.uchile.dcc
package gwent

class SetOfCardsTest extends munit.FunSuite{
  var carta1: Card = null
  var carta2: Card = null
  var carta3: Card = null
  var carta4: Card = null
  var carta5: Card = null
  var mazo1: Deck = null
  var mano1: Hand = null

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new Card("1")
    carta2 = new Card("2")
    carta3 = new Card("3")
    carta4 = new Card("4")
    mazo1 = new Deck(Array(carta1, carta2, carta3))
    mano1 = new Hand(Array(carta4))
    carta5 = new Card("5")
  }

  test("equals") {
    assertEquals(mazo1, Deck(Array(Card("1"), Card("2"), Card("3"))))
  }

  test("draw cards") {
    assertEquals(mazo1.draw(), carta3)
    assertEquals(mano1.draw(), carta4)
  }

  test("add cards") {
    mano1.add(carta5)
    assertEquals(mano1, Hand(Array(carta4,carta5)))
  }
}
