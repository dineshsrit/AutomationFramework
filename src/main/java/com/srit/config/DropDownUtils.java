package com.srit.config;

import com.srit.driver.DriverManager;
import com.srit.enums.WaitStrategy;
import com.srit.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDownUtils {

    public static void dropdownList(By by, String value) throws InterruptedException {
        List<WebElement> webElements= DriverManager.getDriver().findElements(by);
        for(WebElement e:webElements)
        {
            try
            {
                if (e.getText().equalsIgnoreCase(value))
                {
                    System.out.println(e.getText());
                    //e.click();
                    Thread.sleep(1000);
                    dropdownSelect(e);
                    break;
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException("Dropdown value is not selected");
            }
        }

    }

    public static void dropdownSelect(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
