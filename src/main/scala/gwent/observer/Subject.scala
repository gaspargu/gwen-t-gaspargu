package cl.uchile.dcc
package gwent.observer

import scala.collection.mutable.ListBuffer

abstract class Subject[T] extends ISubject[T] {
  val observers: ListBuffer[Observer[T]] = ListBuffer()

  def registerObserver(o: Observer[T]): Unit = observers += o

  def notifyObservers(response: T) = {
    for (o <- observers) {
      o.update(this, response)
    }
  }
}
