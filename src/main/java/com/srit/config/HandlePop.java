package com.srit.config;

import com.srit.driver.Driver;
import com.srit.driver.DriverManager;
import com.sun.java.util.jar.pack.DriverResource;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandlePop {

    static String  mainWindow=null;
    public static void getHandlePop()
    {
        mainWindow= DriverManager.getDriver().getWindowHandle();
       Set<String> allWindowHandles=DriverManager.getDriver().getWindowHandles();
       Iterator<String> iterator=allWindowHandles.iterator();
       while (iterator.hasNext())
       {
           String childWindow=iterator.next();
           if(!mainWindow.equalsIgnoreCase(childWindow))
           {
               DriverManager.getDriver().switchTo().window(childWindow);

           }

       }

        DriverManager.getDriver().switchTo().window(mainWindow);
    }


}
