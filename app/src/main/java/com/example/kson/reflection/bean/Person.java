package com.example.kson.reflection.bean;

public class Person {
    public String name;
    public int age;

    /**
     * 无参
     */
    public Person(){

    }

    /**
     * 有参构造方法
     * @param name
     */
    public Person(String name){

    }

    /**
     * 私有
     * @param name
     * @param age
     */
    private Person(String name,int age){

    }

    /**
     * 方法
     */
    public void fun(){

        String name;//局部变量

        System.out.println("fun");

    }

    /**
     * 私有的，受保护的等权限的方法，通过反射都可以调用，可见性的修改
     */
    private void fun1(){

    }
}
