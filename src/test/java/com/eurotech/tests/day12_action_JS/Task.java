package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // navigate to "https://the-internet.herokuapp.com/hovers"
    // hover over each image one by one and assert the text is displayed

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        for(int i = 1 ; i <= 3 ; i++){
            String imageXpath = "(//div[@class='figure']//img)[" + i +"]";
            WebElement image = driver.findElement(By.xpath(imageXpath));

            Actions actions = new Actions(driver);
            Thread.sleep(1);
            actions.moveToElement(image).perform();

            String imageText = "//h5[text()='name: user" + i + "']";
            WebElement text = driver.findElement(By.xpath(imageText));
            System.out.println(text.getText());

            Assert.assertTrue(text.isDisplayed(), "text is not displayed for for image " + i);
        }
    }

    @Test
    public void hoverOverList() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> threeImages = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> texts = driver.findElements(By.xpath("//div[@class='figcaption']/h5"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < threeImages.size(); i++) {
            threeImages.get(i).click();
            actions.moveToElement(threeImages.get(i)).perform();
            Thread.sleep(2000);
            WebElement text = texts.get(i);

            Assert.assertTrue(text.isDisplayed());
            System.out.println("texts.get(i).getText() = " + texts.get(i).getText());
        }
    }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }
    }
