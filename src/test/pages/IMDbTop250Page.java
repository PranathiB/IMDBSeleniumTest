package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
