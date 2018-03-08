package thejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chensongkui on 2017/9/21.
 * https://www.tutorialspoint.com/java/java_regular_expressions.htm
 */
public class RegexGroup {
    public static void main( String args[] ) {
        // String to be scanned to find the pattern.


        //组   连续   像这样就是NO MATCH  如果是两个4  则两个group各占一个4
        //如果是(.*?)开启非贪婪模式
        //我认为组的意义在于  人为地将字符串分割   从而每一组对应一部分   前提是可以对的上  否则就狗带了
        String line = "This order was plac4ed fo5r QT! OK?";
        String pattern = "(\\d+)(\\d+)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        System.out.println(m.groupCount());
//        if (m.find()) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        }else {
//            System.out.println("NO MATCH");
//        }

        int count = 0;
        while(m.find()) {//可以调用m.start(group)
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
}
