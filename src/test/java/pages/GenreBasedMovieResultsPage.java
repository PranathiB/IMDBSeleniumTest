package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Genre based page object.
 * Returns the total movie results found on the page
 * Returns title of the page
*/

public class GenreBasedMovieResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators of interest on the page
    private By movieResultsList = By.cssSelector(".lister-list");

    GenreBasedMovieResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public int getMovieResultsCount() {
        waitUntilAllElementsAreVisible(movieResultsList);
        return driver.findElements(movieResultsList).size();
    }
    private void waitUntilAllElementsAreVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
