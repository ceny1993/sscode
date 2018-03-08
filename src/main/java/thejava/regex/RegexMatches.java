package thejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chensongkui on 2017/9/21.
 */
public class RegexMatches {

    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main( String args[] ) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
//        System.out.println(matcher.find());
//        System.out.println(matcher.find());
        //lookingAt()  只要从头开始有匹配就OK
        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("matches(): "+matcher.matches());
        System.out.println(matcher.find());


        //1  find不是等幂操作
        //2  如果25行的结果为TRUE  则27为FALSE
    }
}
