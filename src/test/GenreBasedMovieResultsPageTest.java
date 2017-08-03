import org.junit.Assert;
import org.junit.Test;
import pageObjects.GenreBasedMovieResultsPage;

public class GenreBasedMovieResultsPageTest extends BaseTestClass {

    private static final int MINIMUM_RESULTS = 1;
    private static final String EXPECTED_WESTERN_GENRE_PAGE_TITLE = "Highest Rated Western Feature Films";
    private static final String EXPECTED_ROMANCE_GENRE_PAGE_TITLE = "Highest Rated Romance Feature Films";

    @Test
    public void shouldHaveAtLeastOneMovieInWesternGenreResults(){

        GenreBasedMovieResultsPage westernGenreMovieResultsPage = top250ResultsPage.clickOnGenre("Western");

        assertPageTitleForTheGenre("This is not Western Genre page. Did you click on the correct link?",
                westernGenreMovieResultsPage.getTitle(), EXPECTED_WESTERN_GENRE_PAGE_TITLE);

        assertThatAtLeastOneMovieResultIsDisplayed(westernGenreMovieResultsPage.getMovieResultsCount());
    }

    @Test
    public void shouldHaveAtLeastOneMovieInRomanceGenreResults(){

        GenreBasedMovieResultsPage romanceGenreMovieResultsPage = top250ResultsPage.clickOnGenre("Romance");

        assertPageTitleForTheGenre("This is not Romance Genre page. Did you click on the correct link?",
                romanceGenreMovieResultsPage.getTitle(), EXPECTED_ROMANCE_GENRE_PAGE_TITLE);

        assertThatAtLeastOneMovieResultIsDisplayed(romanceGenreMovieResultsPage.getMovieResultsCount());
    }


    private void assertPageTitleForTheGenre(String message, String actualTitle, String expectedTitle) {
        Assert.assertTrue(message, actualTitle.contains(expectedTitle));
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed(int totalMovieResults) {
        Assert.assertTrue("At least one movie result is expected for the selected genre",
                totalMovieResults >= MINIMUM_RESULTS);
    }
}
