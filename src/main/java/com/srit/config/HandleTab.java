package com.srit.config;

import com.srit.driver.DriverManager;

import java.util.ArrayList;
import java.util.Set;

public class HandleTab {


    public static void getHandleTab(int value)
    {

       Set<String> alltabs= DriverManager.getDriver().getWindowHandles();
        ArrayList tabs=new ArrayList(alltabs);
        DriverManager.getDriver().switchTo().window((String) tabs.get(value));

    }
}
