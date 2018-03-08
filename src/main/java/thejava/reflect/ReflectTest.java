package thejava.reflect;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chensongkui on 2018/1/24.
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IOException {
        Class myclass = ChenMeili.class;
        //Class myclass = new ChenMeili().getClass();
        System.out.println(myclass.getName());
        Method[] methods = myclass.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
            System.out.println(method.getDeclaredAnnotations());
        }
        try {
            Method method = myclass.getMethod("ttt", new Class[]{String.class});
            method.invoke(null, "");
            method.invoke(new Object(), "");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("----");
        System.out.println(myclass.getModifiers());

        System.out.println(Object.class.getSuperclass());

        System.out.println("----");
        Constructor[] constructors = myclass.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println( constructor.getParameterCount());
        }

        Field[] fields = myclass.getFields();
        Field[] pFields = myclass.getDeclaredFields();

        B b = new B();
        Field field = b.getClass().getDeclaredField("y");//x会报错  虽然B继承了A
        field.setAccessible(true);
        System.out.println(field.get(b));

        Method method = MyClass.class.getMethod("getStringList", null);

        Type returnType = method.getGenericReturnType();

        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
            /**
             * typeArgClass = class java.lang.String
             typeArgClass = class java.lang.Integer
             */
        }



    }

    public class MyClass {

        protected Map<String, Integer> stringList = new HashMap<String, Integer>();

        public Map<String, Integer> getStringList(){
            return this.stringList;
        }
    }
}
