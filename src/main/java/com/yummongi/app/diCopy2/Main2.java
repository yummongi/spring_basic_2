package com.yummongi.app2.diCopy2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car {
}

class SportsCar extends Car {
}

class Truck extends Car {
}

class Engine {
}

class AppContext {
    Map map; //객체 저장소

    AppContext(){
        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));
            map = new HashMap(p); //map으로 옮김

            for(Object key: map.keySet()){
                Class clazz = Class.forName((String)map.get(key));
                map.put(key, clazz.newInstance());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Object getBean(String key){ return map.get(key);}
}
public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car = (Car) ac.getBean("car");
        System.out.println("car = " + car);
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("engine = " + engine);
    }
}