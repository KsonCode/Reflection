package com.example.kson.reflection;

import com.example.kson.reflection.bean.Person;

import java.lang.reflect.Constructor;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args){

        String s = "";
        String s1 = new String("");

        Class<String> c = String.class;

        Class<Person> pcls = Person.class;
        Class<Void> vclz = Void.class;

        int i = 0;

        Class<Integer> integerClass = Integer.class;

        Person person = new Person();
        person.fun();

        //第一种
        Class c1 = Person.class;

        //第二种
        Class c2 = person.getClass();

        //第三种
        try {
            Class c3 = Class.forName("com.example.kson.reflection.bean.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //创建对象
        try {
            //调用无参数构造函数
            Person p = (Person) c1.newInstance();
            p.fun();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        //获取构造方法
        try {
            Constructor constructor = c1.getConstructor(null);
            Constructor constructor1 = c1.getConstructor(String.class);
            Constructor constructor2 = c1.getDeclaredConstructor(String.class,int.class);
            constructor2.setAccessible(true);//暴力访问，access是访问
            System.out.println("cname:"+constructor.getName());
            //创建对象，并传值
            Person p = (Person) constructor.newInstance(null);
            p.fun();

            Person p1 = (Person) constructor1.newInstance("kson");

            Person p2 = (Person) constructor2.newInstance("kson1",100);

            System.out.println(p1.name);
            System.out.println(p2.name);




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
