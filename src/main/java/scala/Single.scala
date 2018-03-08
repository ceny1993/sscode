package scala

/**
  * Created by chensongkui on 2018/3/8.
  */
class Single {
  val id = Single.newUniqueNumber()
  var balance = 0.0
  def deposit(amount: Double) {
    println(balance)
  }
}

object Single {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber}
}
