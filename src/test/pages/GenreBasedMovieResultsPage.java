package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenreBasedMovieResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;
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
