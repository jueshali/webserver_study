package study_01;

import java.lang.reflect.InvocationTargetException;

/**
 * 项目名：webserver_study
 * 描述：反射学习
 *clz.getConstructor().newInstance()
 * @author : Lpc
 * @date : 2019-07-09 21:25
 **/
public class Reflect {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Class clz = Iphone.class;
        clz = iphone.getClass();
        try {
            clz = Class.forName("study_01.Iphone");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}


class Iphone{
    public Iphone(){

    }
}