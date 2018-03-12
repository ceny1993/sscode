package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chensongkui on 2018/3/8.
 * https://www.cnblogs.com/ninth/p/6841608.html
 */

public class TestAop {
    public static void main(String[] args) {
        //ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClassA classA = context.getBean(ClassA.class);
        classA.doSth();
    }
}
