package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WesternGenreMovieResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By movieListSelector = By.cssSelector(".lister-list");

    public WesternGenreMovieResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public int getMoviesCount() {
        waitUntilAllElementsAreVisible(movieListSelector);
        List< WebElement > moviesList = driver.findElements(movieListSelector);
        return moviesList.size();
    }
    private void waitUntilAllElementsAreVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }
}
