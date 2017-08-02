import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.IMDbTop250MovieResultsPage;
import pages.WesternGenreMovieResultsPage;

public class TopRatedMoviesByGenrePageTest extends BaseTest {
    private IMDbTop250MovieResultsPage top250ResultsPage;
    private WesternGenreMovieResultsPage westernGenreMovieResultsPage;

    private static final int MINIMUM_RESULTS = 1;


    @Before
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250MovieResultsPage(driver);
        top250ResultsPage.go();
    }

    @Test
    public void shouldHaveAtLeastOneMovieInWesternGenre(){
        westernGenreMovieResultsPage = top250ResultsPage.clickOnWesternGenreLinkFromSideBar();
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue("At least one movie is expected in the list",
                westernGenreMovieResultsPage.getMoviesCount() >= MINIMUM_RESULTS);
    }
}
