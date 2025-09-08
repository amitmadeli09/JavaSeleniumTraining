package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    // Get driver instance from your test class using reflection
    private WebDriver getDriver(ITestResult result) {
        Object testClass = result.getInstance();
        try {
            return (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void takeScreenshot(WebDriver driver, String methodName, String status) {
        if (driver == null) return;

        // create timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // create folder if not exists
        File screenshotsDir = new File("src/test/resources/screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }

        // file path
        String screenshotPath = screenshotsDir + File.separator + methodName + "_" + status + "_" + timestamp + ".png";

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Saved screenshot: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = getDriver(result);
        takeScreenshot(driver, result.getMethod().getMethodName(), "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriver(result);
        takeScreenshot(driver, result.getMethod().getMethodName(), "FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver driver = getDriver(result);
        takeScreenshot(driver, result.getMethod().getMethodName(), "SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}

    @Override
    public void onTestStart(ITestResult result) {}
}
