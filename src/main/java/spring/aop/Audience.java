package spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Comparator;

/**
 * Created by chensongkui on 2018/3/10.
 */
@Aspect
public class Audience {


    public Audience(){
        System.out.println("build audience");
    }


    @Before("execution(** ClassA.doSth(..))")
    public void silenceMobile(){
        System.out.println("keep silence");
        new Comparator<ClassA>(){

            public int compare(ClassA o1, ClassA o2) {
                return 0;
            }
        };
    }

}
