package cl.uchile.dcc
package gwent.effects

import gwent.Player
import gwent.board.Board
import gwent.cards.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

class TestEffect extends munit.FunSuite {
  var jugador1: Player = null
  var jugador2: Player = null
  var nullEffect = NullEffect
  var moraleBoost: MoraleBoost = new MoraleBoost
  var cartaEfecto: CloseCombatCard = null
  var carta1: CloseCombatCard = null
  var carta2: SiegeCombatCard = null
  var carta3: SiegeCombatCard = null
  var board: Board = null

  override def beforeEach(context: BeforeEach): Unit= {
    cartaEfecto = new CloseCombatCard("Carta Efecto","",12, moraleBoost)
    carta1 = new CloseCombatCard("carta1","",7, nullEffect)
    carta2 = new SiegeCombatCard("carta2", "", 2, nullEffect)
    carta3 = new SiegeCombatCard("carta3", "", 5, nullEffect)
    jugador1 = new Player("Jugador 1", 3, List(), List(cartaEfecto,carta1,carta2,carta3))
    jugador2 = new Player("Jugador 2", 3, List(), List())
    board = new Board(jugador1, jugador2)
    board.player1PlayCard(carta1)
    board.player1PlayCard(carta2)
    board.player1PlayCard(carta3)
  }

  test("MoralBoost add +1 to cards of same row") {
    board.player1PlayCard(cartaEfecto)
    assertEquals(board.zone1.closecombatZone.show, List())
  }

  
}
