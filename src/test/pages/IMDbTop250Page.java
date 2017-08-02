package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IMDbTop250Page {
    private WebDriver driver;
    private WebDriverWait wait;

    private By SortBySelector = By.cssSelector(".lister-sort-by");
    private By movieListSelector = By.cssSelector(".lister-list tr");

    public IMDbTop250Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void go(){
        final String URL = "http://www.imdb.com/chart/top";
        driver.get(URL);
    }

    public int getMoviesCount() {
        waitUntilAllElementsAreVisible(movieListSelector);
        List< WebElement > moviesList = driver.findElements(movieListSelector);
        return moviesList.size();
    }
    private void waitUntilAllElementsAreVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void sortMoviesBy(String sortOption) {
        waitUntilAllElementsAreVisible(SortBySelector);
        Select sortingSelector = new Select(driver.findElement(SortBySelector));
        sortingSelector.selectByVisibleText(sortOption);
    }

    public String getFirstResultTitle(){
        waitUntilAllElementsAreVisible(movieListSelector);
        List< WebElement > moviesList = driver.findElements(movieListSelector);
        return moviesList.get(0).getText();
    }
}
