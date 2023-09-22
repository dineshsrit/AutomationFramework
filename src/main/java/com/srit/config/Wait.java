package com.srit.config;

import com.srit.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait {


    static WebDriverWait wait=null;

    public static void waitClickable(long value, WebElement element)
    {
        wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(value));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
