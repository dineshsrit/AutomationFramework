package com.srit.config;

import com.srit.driver.DriverManager;
import com.srit.waits.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Alertutils {



    public static void acceptAlert()
    {
        try
        {
            Wait.getWait().until(ExpectedConditions.alertIsPresent());
            Alert alert= DriverManager.getDriver().switchTo().alert();
            alert.accept();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public  static String getAlertText()
    {
        Alert alert= DriverManager.getDriver().switchTo().alert();
        String alerttext= alert.getText();
        return alerttext;
    }
}
