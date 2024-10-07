package com.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetry = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetry) {
            retryCount++;
            return true;
        }
        return false;
    }
}
