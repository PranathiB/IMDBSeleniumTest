import org.junit.Assert;
import org.junit.Test;

public class IMDbTop250MovieResultsPageTest extends BaseTestClass {
    private static final int MINIMUM_RESULTS = 1;
    private static final int MAXIMUM_RESULTS = 250;

    @Test
    public void shouldHaveAtLeastOneMovieOnTopRatedMoviesPage(){
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByReleaseDate(){
        top250ResultsPage.sortMoviesBy("Release Date");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByImdbRating(){
        top250ResultsPage.sortMoviesBy("IMDb Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByNumberOfRatings(){
        top250ResultsPage.sortMoviesBy("Number of Ratings");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByRanking(){
        top250ResultsPage.sortMoviesBy("Ranking");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByYourRating(){
        top250ResultsPage.sortMoviesBy("Your Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM_RESULTS);
    }

    private void assertMaximumResultsCount() {
        Assert.assertTrue("At max 250 movies are expected in the list",
                top250ResultsPage.getMoviesCount() <= MAXIMUM_RESULTS);
    }

}
