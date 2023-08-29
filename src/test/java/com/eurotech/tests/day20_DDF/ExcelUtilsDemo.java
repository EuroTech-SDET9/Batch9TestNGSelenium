package com.eurotech.tests.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    //Create an object from excel util
    //It accepts two arguments
    //Argument 1 : location of the file (path)
    //Argument 2 : sheet name that we want to open

    @Test
    public void readExcelFile() {

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/EurotechTest.xlsx","Login Test");


        //How many rows in the sheet
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());


        //how many columns in the sheet
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());


        //get all columns name
        System.out.println("excelUtil.getColumnsNames() = " + excelUtil.getColumnsNames());



        //get all data in the sheet
        List<Map<String, String>> dataList = excelUtil.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }


        //print seyit datas
        System.out.println("dataList.get(3) = " + dataList.get(4));

        //print gulcan's company     Amazon
        System.out.println("dataList.get(2).get(\"Company\") = " + dataList.get(2).get("Company"));

        //print Seyit's title
        System.out.println("dataList.get(4).get(\"Title\") = " + dataList.get(4).get("Title"));


        //print Erkan's password
        System.out.println("dataList.get(5).get(\"Password\") = " + dataList.get(5).get("Password"));


        //get array
        String[][] dataArray = excelUtil.getDataArray();
        System.out.println("dataArray = " + Arrays.deepToString(dataArray));
    }
}
