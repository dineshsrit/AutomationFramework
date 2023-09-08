package com.srit.config;

import com.srit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll {

    public static void scrolldown(WebElement by)
    {
        JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", by );
    }
}
