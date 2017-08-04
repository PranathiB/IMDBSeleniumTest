import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class IMDbTop250MovieResultsPageTest extends BaseTestClass {
    private static final int MINIMUM_RESULTS = 1;
    private static final int MAXIMUM_RESULTS = 250;

    @Test
    public void shouldHaveAtLeastOneMovieOnTopRatedMoviesPage(){
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }

    @DataProvider(name="SortCriteria")
    public Object[] sortByOption(){
        return new String[]{"Release Date","IMDb Rating", "Number of Ratings","Ranking", "Your Rating"};

    }
    @Test(dataProvider="SortCriteria")
    public void shouldHaveAtLeastOneMovieWhenSortedBy(String sortOption) throws InterruptedException{
        top250ResultsPage.sortMoviesBy(sortOption);
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximumResultsCount();
    }
    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue(top250ResultsPage.getMoviesCount() >= MINIMUM_RESULTS,
                "At least one movie is expected in the list");
    }

    private void assertMaximumResultsCount() {
        Assert.assertTrue(top250ResultsPage.getMoviesCount() <= MAXIMUM_RESULTS,
                "At max 250 movies are expected in the list");
    }

}
