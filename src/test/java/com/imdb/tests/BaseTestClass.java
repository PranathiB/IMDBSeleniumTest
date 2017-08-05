package com.imdb.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.IMDbTop250MovieResultsPage;


/***

    BASE TEST CLASS to initiate webdriver and open the url

***/

public class BaseTestClass {

    private static ChromeDriver driver;

//    @Rule
//    public TestRule screenshotTaker = new ScreenshotHelperClass((TakesScreenshot) driver);
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

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
