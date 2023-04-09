package cl.uchile.dcc
package gwent

class PlayerTest extends munit.FunSuite{
  var jugadorJaime: Player = null
  var jugadorPepe: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugadorJaime = new Player("Jaime", true, 2, Deck(Array(Card("carta 1"),
      Card("carta 2"))), Hand(Array(Card("carta 3"))))
    jugadorPepe = new Player("Jaime", false, 2, Deck(Array(Card("carta 4"),
      Card("carta 4"))), Hand(Array(Card("carta 6"))))
  }
  
  test("equals") {
    assertEquals(jugadorJaime, Player("Jaime", true, 2, Deck(Array(Card("carta 1"),
      Card("carta 2"))), Hand(Array(Card("carta 3")))))
    assertNotEquals(jugadorJaime,jugadorPepe)
  }

  test("draw a card from the deck") {
    jugadorJaime.draw()
    assertEquals(jugadorJaime, new Player("Jaime", true, 2, Deck(Array(Card("carta 1"))), 
      Hand(Array(Card("carta 3"),Card("carta 2")))))
  }
  
  test("play a card from the hand") {
    jugadorJaime.playCard() 
    assertEquals(jugadorJaime, new Player("Jaime", true, 2, Deck(Array(Card("carta 1"),
      Card("carta 2"))), Hand(Array())))
  }

}
