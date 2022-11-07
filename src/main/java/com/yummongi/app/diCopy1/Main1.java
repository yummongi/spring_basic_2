package com.yummongi.app2.diCopy1;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;

class Car {
}

class SportsCar extends Car {
}

class Truck extends Car {
}

class Engine {
}

class AppContext{
    HashMap map;

    public AppContext() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));
        map = new HashMap(p);

        for(Object key: map.keySet()){
            Class clazz = Class.forName((String) map.get(key));
            map.put(key, clazz.newInstance());
        }
    }

    Object getBean(String key) throws Exception{
        return map.get(key);
    }
}
public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = (Car) getObject("car");
        System.out.println("car = " + car);
        Engine engine = (Engine) getObject("engine");
        System.out.println("engine = " + engine);

        AppContext ax = new AppContext();
        Car car1 = (Car) ax.getBean("car");
    }

    static Object getObject(String key) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        //config.txt 의 key 가 car 인 value 값 얻어오기
        Class clazz = Class.forName(p.getProperty(key));

        //객체를 만든다.
        return clazz.newInstance();
    }


}
