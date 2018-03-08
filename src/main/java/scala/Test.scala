package scala

/**
  * Created by chensongkui on 2017/9/28.
  */
object Test {
  def main(args: Array[String]) = {
    delayed(time())
    println("------------")
    getAns(time());
    var factor = 3
    //val multiplier = () => 2 * factor;
    def multiplier() = {
      2 * factor;
    }


    factor = 4;
    println( "muliplier(1) value = " +  multiplier() )
    println( "muliplier(2) value = " +  multiplier() )
    var myList = Array(1.9, 2.9, 3.4, 3.5)

    // 输出所有数组元素
    for ( x <- myList ) {
      println( x )
    }

  }

  var x=9;

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  //传名调用
  def delayed( t: => Long ) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  //传值调用
  def getAns(t: Long) ={
    println("在 getAns 方法内")
    println("参数： " + t)
    t
  }



}
