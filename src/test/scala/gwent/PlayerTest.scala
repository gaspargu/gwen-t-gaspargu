package cl.uchile.dcc
package gwent

class PlayerTest extends munit.FunSuite{
  var jugadorJaime: Player = null
  var jugadorPepe: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugadorJaime = new Player("Jaime", true, 2, Deck(Array(Card("1"),
      Card("2"))), Hand(Array(Card("3"))))
    jugadorPepe = new Player("Pepe", false, 2, Deck(Array(Card("4"),
      Card("5"))), Hand(Array(Card("6"))))
  }

  test("equals") {
    assertEquals(jugadorJaime, Player("Jaime", true, 2, Deck(Array(Card("1"),
      Card("2"))), Hand(Array(Card("3")))))
    assertNotEquals(jugadorJaime,jugadorPepe)
  }

  test("draw a card from the deck") {
    jugadorJaime.draw()
    assertEquals(jugadorJaime, Player("Jaime", true, 2, Deck(Array(Card("carta 1"))),
      Hand(Array(Card("carta 3"),Card("carta 2")))))
  }

  test("play a card from the hand") {
    jugadorJaime.playCard()
    assertEquals(jugadorJaime, Player("Jaime", true, 2, Deck(Array(Card("carta 1"),
      Card("carta 2"))), null))
  }

}
