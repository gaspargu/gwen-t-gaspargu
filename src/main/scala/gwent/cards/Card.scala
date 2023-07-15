package cl.uchile.dcc
package gwent.cards

import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

import cl.uchile.dcc.gwent.effects.Effect

/** Trait representing a card in the Gwen't game.
 *
 * A card is characterized by its [[name]] and [[description]].
 * This trait serves as a common interface for all card types and ensures that every card,
 * regardless of its specific subtype, will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are
 * immutable -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them.
 *
 * The actual content of these properties, as well as any additional properties or
 * behaviours, are to be defined in the concrete classes that extend this trait.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Gaspar Gumucio Gallardo~
 * @version 1.1
 * @since 1.0
 */
trait Card {

  /** Getter method to the name of the card.
   * This is an immutable property.
   */
  def name: String

  /** Getter method to the description of the card.
   * Is a description of the card's properties or effects.
   * This is an immutable property.
   */
  def description: String

  def toString: String
  
  def effect: Effect

  /**
   *
   * This method is called when this card is try to be played in the board.
   * Depending if the concrete type of the card match with the zone, the method implemented must
   * add the card to the zone, or do nothing if not match with the type.
   *
   * @param zone The CloseCombatZone of the board where the card is try to be played.
   * */
  def putInCloseCombatZone(zone: CloseCombatZone): Unit

  def putInSiegeZone(zone: SiegeZone): Unit

  def putInRangedZone(zone: RangedZone): Unit
  
  def putInWeatherzone(zone: WeatherZone): Unit
  
  
}
