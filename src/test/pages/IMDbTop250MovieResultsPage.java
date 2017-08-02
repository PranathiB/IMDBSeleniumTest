package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IMDbTop250MovieResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

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
    private void waitUntilAllElementsAreVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void sortMoviesBy(String sortOption) {
        waitUntilAllElementsAreVisible(SortByDropDown);
        Select sortingDropDown = new Select(driver.findElement(SortByDropDown));
        sortingDropDown.selectByVisibleText(sortOption);
    }

    public String getFirstResultTitle(){
        waitUntilAllElementsAreVisible(movieResultsList);
        List< WebElement > moviesList = driver.findElements(movieResultsList);
        return moviesList.get(0).getText();
    }

    public WesternGenreMovieResultsPage clickOnWesternGenreLinkFromSideBar() {
        waitUntilAllElementsAreVisible(movieGenreSideBarLinks);
        clickOnGenre("Western");
        return new WesternGenreMovieResultsPage(driver);
    }

    private void clickOnGenre(String genreName) {
        driver.findElement(By.linkText(genreName)).click();
    }
}
