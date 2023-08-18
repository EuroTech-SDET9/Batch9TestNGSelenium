package com.eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class InstantiateSingletonClassExample {

    @Test
    public void test() {

//        SingletonClassExample singleton = new SingletonClassExample();

        SingletonClassExample singleton = SingletonClassExample.getInstanceOfSingletonClassExample();

        SingletonClassExample singleton2 = SingletonClassExample.getInstanceOfSingletonClassExample();

    }
}
