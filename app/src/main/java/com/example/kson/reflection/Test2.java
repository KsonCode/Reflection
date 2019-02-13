package com.example.kson.reflection;

import com.example.kson.reflection.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) {

        String s = "";
        String s1 = new String("");
        Class c = String.class;

        Class<Float> floatClass = float.class;
        Class<Void> voidClass = Void.class;


        try {
            //person类的类实例，类的类类型
            Class<Person> personClass = Person.class;
            //通过clss类型创建对象
            Person person1 = personClass.newInstance();
            person1.fun();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        //第一种
        Class<Person> personClass = Person.class;

        //第二种
        Person person = new Person();
        Class<Person> aClass1 = (Class<Person>) person.getClass();

        //第三种
        try {
            Class<Person> aClass = (Class<Person>) Class.forName("com.example.kson.reflection.entity.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor = personClass.getConstructor(null);

//            Person person1 = new Person();

            //通过反射构造器创建对象
            Person person1 = (Person) constructor.newInstance(null);

            person1.fun();

            //获取私有构造器
//            Constructor constructor1 = aClass1.getConstructor(int.class);
            Constructor constructor1 = aClass1.getDeclaredConstructor(int.class);//declared

            //暴力访问
            constructor1.setAccessible(true);//访问

            constructor1.newInstance(100);
//            Constructor constructor1 = aClass1.getConstructor(int.class);
            //私有三个参数
            Constructor constructor2 = aClass1.getDeclaredConstructor(String.class, int.class);//declared

            //暴力访问
            constructor2.setAccessible(true);//访问

            constructor2.newInstance("张三", 100);


            //获取某一个方法，无参，第一个参数方法名，第二个参数类型（Class类型）
            Method method = personClass.getMethod("fun", null);
            //执行方法，第一个参数是类的对象，第二个是参数值传递
            method.invoke(personClass.newInstance(), null);

//            Method method1 = personClass.getDeclaredMethod("fun2",String.class,String.class,int.class);
            Method method1 = personClass.getDeclaredMethod("fun2", new Class<?>[]{String.class, String.class, int.class});

            method1.setAccessible(true);//
            method1.invoke(personClass.newInstance(), "kson", "k", 99);


            Person person2 = new Person();
            //获取域对象
            Field field = personClass.getDeclaredField("age");
            field.setAccessible(true);//访问
            //修改域的值
            field.set(person2,100);
            person2.getAge();

            //遍历所有的域，成员变量
            Field[] fields = personClass.getFields();//获取public的

            if (fields!=null&&fields.length>0){
                for (Field field1 : fields) {

//                    System.out.println("fname==="+field1.getName()+" ftype==="+field1.getType());

                }
            }
            //遍历所有的域，成员变量
            Field[] fields2 = personClass.getDeclaredFields();//获取public的

            if (fields2!=null&&fields2.length>0){
                for (Field field2 : fields2) {


                    System.out.println("fname==="+field2.getName()+" ftype==="+field2.getType());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
