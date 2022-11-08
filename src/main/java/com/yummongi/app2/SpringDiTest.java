package com.yummongi.app2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

class Car{
    String color;
    int oil;
    Engine engine;
    Door[] doors;

    public Car(String color, int oil, Engine engine, Door[] doors) {
        this.color = color;
        this.oil = oil;
        this.engine = engine;
        this.doors = doors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door[] getDoors() {
        return doors;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;


    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
class Engine{}
class Door{}

public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        //Car car = (Car) ac.getBean("car"); //byName
        //위와 동일, 형변환 하지 않아도 된다.
        Car car = ac.getBean("car", Car.class); //byName
        Car car2 = ac.getBean(Car.class); //byType
        Engine engine = (Engine) ac.getBean("engine");
        Door door = (Door) ac.getBean("door");

        //car 객체 멤버 초기화
/*        car.setColor("red");
        car.setOil(100);
        car.setEngine(engine);
        car.setDoors(new Door[]{ac.getBean("door", Door.class),ac.getBean("door", Door.class)});*/

        System.out.println("car = " + car);
    }
}
