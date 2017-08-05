package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/*
 * Top 250 movie results page object.
 * Returns the total movie results found on the page
 * Clicks on dropdown to select a sorting category
*/

public class IMDbTop250MovieResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators of interest on top movies page
    private By SortByDropDown = By.cssSelector(".lister-sort-by");
    private By movieResultsList = By.cssSelector(".lister-list tr");
    private By movieGenreSideBarLinks = By.cssSelector(".quicklinks");


    public IMDbTop250MovieResultsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void go(){
        final String URL = "http://www.imdb.com/chart/top";
        driver.get(URL);
    }

    public int getMoviesCount() {
        waitUntilAllElementsAreVisible(movieResultsList);
        List< WebElement > moviesList = driver.findElements(movieResultsList);
        return moviesList.size();
    }

    public void sortMoviesBy(String sortOption) {
        waitUntilAllElementsAreVisible(SortByDropDown);
        new Select(driver.findElement(SortByDropDown)).selectByVisibleText(sortOption);
    }

    public String getFirstMovieResultTitle(){
        waitUntilAllElementsAreVisible(movieResultsList);
        return driver.findElements(movieResultsList).get(0).getText();
    }

    public GenreBasedMovieResultsPage clickOnGenre(String genreName) {
        waitUntilAllElementsAreVisible(movieGenreSideBarLinks);
        driver.findElement(By.linkText(genreName)).click();
        return new GenreBasedMovieResultsPage(driver);
    }

    private void waitUntilAllElementsAreVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }
}
