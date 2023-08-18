package com.eurotech.tests.day14_PropertiesSingleton;

public class SingletonClassExample {

    private static SingletonClassExample instanceOfSingletonClassExample;


    private SingletonClassExample(){
        System.out.println("Creating a SingletonClassExample object");
    }

    public static SingletonClassExample getInstanceOfSingletonClassExample(){
        if(instanceOfSingletonClassExample == null){
            instanceOfSingletonClassExample = new SingletonClassExample();
        }else{
            System.out.println("It has already been instantiated, returning existing instance of SingletonClassExample");
        }
        return instanceOfSingletonClassExample;
    }

}
