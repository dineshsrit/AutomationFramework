package com.srit.config;

import com.srit.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {


    public static void ScrollIntoView(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
