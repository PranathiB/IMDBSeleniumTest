import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.IMDbTop250MovieResultsPage;

public class Top250MoviesPageTest extends BaseTest{
    private static final int MINIMUM_RESULTS = 1;
    private static final int MAXIMUM_RESULTS = 250;
    private IMDbTop250MovieResultsPage top250ResultsPage;

    @Before
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250MovieResultsPage(driver);
        top250ResultsPage.go();
    }

    @Test
    public void shouldHaveAtLeastOneMovieOnTopRatedMoviesPage(){
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByReleaseDate(){
        top250ResultsPage.sortMoviesBy("Release Date");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByImdbRating(){
        top250ResultsPage.sortMoviesBy("IMDb Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByNumberOfRatings(){
        top250ResultsPage.sortMoviesBy("Number of Ratings");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByRanking(){
        top250ResultsPage.sortMoviesBy("Ranking");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByYourRating(){
        top250ResultsPage.sortMoviesBy("Your Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM_RESULTS);
    }

    private void assertMaximunResultsCount() {
        Assert.assertTrue("At max 250 movies are expected in the list",
                top250ResultsPage.getMoviesCount() <= MAXIMUM_RESULTS);
    }

}
