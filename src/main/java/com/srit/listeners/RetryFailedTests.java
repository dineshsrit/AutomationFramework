package com.srit.listeners;

import com.srit.config.PropertyUti;
import com.srit.enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests  implements IRetryAnalyzer {

    private int count=0;
    private int retry=1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        try {
            if(PropertyUti.get(ConfigProperties.RETRY).equalsIgnoreCase("yes")) {

                if (count < retry) {
                    count++;
                    return true;
                }


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
