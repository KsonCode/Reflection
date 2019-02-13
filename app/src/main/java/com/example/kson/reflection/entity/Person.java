package com.example.kson.reflection.entity;

public class Person {
    public String name;//全局变量、属性、成员变量、域（field）
    private int age;

    /**
     * 私有构造器
     * @param age
     */
    private Person(int age){
        this.age = age;

        System.out.println("age："+this.age);

    }

    /**
     * 无参
     */
    public Person(){
        System.out.println("无参构造器");

    }

    /**
     * public 有参的
     * @param name
     */
    public Person(String name){

    }

    /**
     * private
     * @param name
     * @param age
     */
    private Person(String name,int age){

        System.out.println("name:"+name+" age="+age);

    }


    public void fun() {
        String name;//局部变量，生命周期
        System.out.println("fun");
    }

    /**
     * 私有方法
     */
    private void fun2(String name,String s,int a){

        System.out.println("私有方法，fun2的nname======="+name);

    }

    public int getAge() {

        System.out.println("age==="+age);

        return -1;
    }
}
