import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.aop.ClassA;

/**
 * Created by chensongkui on 2018/3/8.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
// TODO: 2018/3/8 *为什么不行
public class SimpleTest {


    @Autowired
    ClassA classA;

    @Test
    public void test(){
        classA.doSth();
    }
}
