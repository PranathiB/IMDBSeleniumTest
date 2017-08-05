package com.imdb.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.IMDbTop250MovieResultsPage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/***

    BASE TEST CLASS to initiate webdriver and open the url

***/

public class BaseTestClass {

    private static ChromeDriver driver;

    IMDbTop250MovieResultsPage top250ResultsPage;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250MovieResultsPage(driver);
        top250ResultsPage.go();
    }

    @AfterMethod
    public void onTestFailure(ITestResult result) {

        String methodName = result.getTestName();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
            File destFile = new File((String) reportDirectory+"/"+methodName+ UUID.randomUUID()+".png");
            FileUtils.copyFile(scrFile, destFile);
            Reporter.setEscapeHtml(false);
            Reporter.log("<img src=\"file://" + destFile.getAbsolutePath()  + "\" alt=\"\"/>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
