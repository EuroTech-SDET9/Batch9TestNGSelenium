package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        WebElement tableTitle = driver.findElement(By.xpath("//h2/span[text()='Demo Webtable 2 (Dynamic Table)']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", tableTitle);
    }

    @Test
    public void printTable() throws InterruptedException {

        WebElement table = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(table.getText());
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
                System.out.println("headers size:" + headers.size());

        for(WebElement header : headers){
            System.out.println("header = " + header.getText());
        }
    }

    @Test
    public void getRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println(rows.size());

        // for each to print out every row
        for(WebElement row : rows){
            System.out.println(row.getText());
        }

        System.out.println(" ******** ");

        // print only second row
        WebElement secondRow = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        System.out.println(" ******** ");

        // for loop to print out every row
        for(int i = 1; i <= rows.size() ; i++){
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]"));
            System.out.println(row.getText());
        }

    }

    @Test
    public void getAllCellsInOneRow() {

        List<WebElement> financialCenterCells = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[4]//td"));
        System.out.println("financialCenterCells.size() = " + financialCenterCells.size());

        for(WebElement cell : financialCenterCells){
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getOneCell() {
        // print Shanghai
        WebElement shanghaiCell = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]//td[2]"));
        System.out.println("shanghaiCell = " + shanghaiCell.getText());
    }

    @Test
    public void getAllCellsByIndex() {
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        // iterate each row on the table
        for(int i = 1; i <= rowNumber; i++){
            // iterate each column on the row
            for(int j=1; j < colNumber; j++){
                String cellXpath = "//table[@border='1']/tbody/tr[" + i + "]//td[" + j +"]";
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }
        }
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        return columns.size();
    }

    private int getNumberOfRows(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
