package spring;

import org.springframework.context.annotation.Configuration;

/**
 * Created by chensongkui on 2017/10/27.
 */
@Configuration
public class MyConfig {
    public Test test(){
        return new Test();
    }
}
