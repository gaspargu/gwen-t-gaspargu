package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class AbstractListOfCards(list: ListBuffer[Card]) {
  def getList(): ListBuffer[Card] = list
  
}
