package Utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {
    private int maxRetryCount = 2; // Set the maximum retry count

    @Override
    public boolean retry(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && maxRetryCount > 0) {
            if (result.getThrowable() instanceof AssertionError) {
                // If the failure is due to an assertion error, do not retry
                return false;
            } else {
                // For other types of failures, retry up to the maximum retry count
                maxRetryCount--;
                return true;
            }
        }
        return false; // Do not retry for pass or if max retry count is reached
    }


//public class CustomRetryAnalyzer implements IRetryAnalyzer {
//    public int maxRetryCount = 3; // Set the maximum retry count
//
//    @Override
//    public boolean retry(ITestResult result) {
//        return result.getStatus() == ITestResult.FAILURE && maxRetryCount-- > 0;
//    }

}