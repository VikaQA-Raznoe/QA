package ru.lesson.utills;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private Logger logger = LogManager.getLogger(TestListener.class);
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getTestClass());
        //Делаем скриншот страницы, на которую заходим
        /*File scrFile = ((TakesScreenshot) BaseTest.tearUp()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target\\screeshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}