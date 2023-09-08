package com.srit.config;

import org.openqa.selenium.WebElement;

public class FileUploadUtils {


    public static void fileUpload(WebElement element, String filepath)
    {
        element.sendKeys(filepath);
    }

}
