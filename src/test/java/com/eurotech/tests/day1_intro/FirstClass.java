package com.eurotech.tests.day1_intro;

import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {

        System.out.println("Hello Automation");

        String name = new String("Eurotech");

        Faker faker = new Faker();
        System.out.println("faker.animal().name() = " + faker.animal().name());

        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        System.out.println("faker.address().cityName() = " + faker.address().cityName());

    }

}
