package com.eurotech.tests.day20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {



    @DataProvider
    public Object [][] testData(){

        String [][] data ={
                {"Game Of Thrones","9"},
                {"Breaking Bad","8"},
                {"Friends","8"},
                {"Mr Robot","7"},
                {"Dexter","10"},
                {"Lie to me","6"},
                {"Homeland","7"}
        };

        return data;
    }

    @Test(dataProvider = "testData")
    public void testName(String tvSeries,String rating) {
        System.out.println("Tv Series "+tvSeries+" has rating "+rating);
    }
}
