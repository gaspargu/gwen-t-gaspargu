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

  


}
