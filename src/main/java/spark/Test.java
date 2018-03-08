package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by chensongkui on 2017/9/27.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setAppName("hello").setMaster("local[*]");
        //JavaSparkContext sc = new JavaSparkContext(conf);
//        JavaRDD<String> distFile = sc.textFile("/Users/chensongkui/Desktop/toMingMing");
//        System.out.println(distFile.count());
//        System.out.println(distFile.first());
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));
        JavaDStream<String> lines=jssc.textFileStream("/Users/chensongkui/Desktop/test/");

        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String x) {
                System.out.println(Arrays.asList(x.split(" ")).get(0));
                return Arrays.asList(x.split(" ")).iterator();
            }
        });

        JavaPairDStream<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });

        wordCounts.print();

        System.out.println("ooooo");
       // wordCounts.dstream().saveAsTextFiles("hdfs://192.168.61.128:9000/sparkStream001/wordCount/", "spark");

        jssc.start();
        jssc.awaitTermination();

    }
}
