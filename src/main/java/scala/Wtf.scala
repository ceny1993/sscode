package scala

import org.apache.spark.sql.SparkSession

/**
  * Created by chensongkui on 2017/10/13.
  */
class Wtf {
  def main(args: Array[String]): Unit ={
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate();
    val data = java.util.Arrays.asList(1,2,3,4,5)
    Some(2);
  }
}



