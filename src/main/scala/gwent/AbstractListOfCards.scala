package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

/** An abstract class representing a list of cards.
 *
 * @param list The list buffer of cards.
 *
 * */

class AbstractListOfCards(list: ListBuffer[Card]) {
  def getList(): ListBuffer[Card] = list
  
}
