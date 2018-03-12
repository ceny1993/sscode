package spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by chensongkui on 2018/3/8.
 */

public class ClassA implements Comparable{

    public ClassA(){
        System.out.println("build class A!");
    }

    public void doSth(){
        System.out.println("do sth about A");
    }

    public int compareTo(Object o) {
        return 0;
    }
}
