package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IMDbTop250Page {
    private final String URL = "http://www.imdb.com/chart/top";
    WebDriver driver;

    public IMDbTop250Page(WebDriver driver){
        this.driver = driver;
    }

    public void go(){
        driver.get(URL);
    }

    public int getMoviesCount() {
        List< WebElement > moviesList = driver.findElements(By.cssSelector(".lister-list tr"));
        return moviesList.size();
    }

    public void sortMoviesByRanking() {
        Select sortingSelector = new Select(driver.findElement(By.cssSelector(".lister-sort-by")));
        sortingSelector.selectByVisibleText("Release Date");
    }

    public String getFirstResultTitle(){
        List< WebElement > moviesList = driver.findElements(By.cssSelector(".lister-list tr"));
        return moviesList.get(0).getText();
    }
}
