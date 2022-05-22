package org.example;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

public class CalculationTest {

    public static ChromeOptions chromeOptions;
    public static WebDriver driver;

    @BeforeTest
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
    }

    @Test
    void projectCostTest() {
        driver = new ChromeDriver();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.get("https://wohntraumrechner.bausparen.at/finanzierungsrechner?utm_source=rbsk-website&utm_medium=rechner&utm_campaign=wtr&utm_content=link");

        assertEquals(
                "4.000 EUR",
                driver.findElement(By.id("FinanzierungModel_Projektkosten")).getAttribute("value")
        );

        assertEquals(
                "4.000 EUR",
                driver.findElement(By.className("min")).getAttribute("value")
        );
    }

    @After
    public void quit() {
        driver.close();
    }

}
