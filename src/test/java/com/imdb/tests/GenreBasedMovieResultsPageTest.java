package com.imdb.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GenreBasedMovieResultsPage;

public class GenreBasedMovieResultsPageTest extends BaseTestClass {

    private static final int MINIMUM_RESULTS = 1;


    //Using genre name and page title
    @DataProvider(name="GenreAndTitle")
    public Object[][] genreAndExpectedPageTitle(){
        final String EXPECTED_WESTERN_GENRE_PAGE_TITLE = "Highest Rated Western Feature Films";
        final String EXPECTED_ROMANCE_GENRE_PAGE_TITLE = "Highest Rated Romance Feature Films";
        return new Object[][]{
                { "Western", EXPECTED_WESTERN_GENRE_PAGE_TITLE },
                { "Romance", EXPECTED_ROMANCE_GENRE_PAGE_TITLE }
        };
    }

    @Test(dataProvider="GenreAndTitle")
    public void shouldHaveAtLeastOneMovieInSelectedGenreResults(String genreName, String pageTitle){

        GenreBasedMovieResultsPage genreMovieResultsPage = top250ResultsPage.clickOnGenre(genreName);

        assertPageTitleForTheGenre("This is not "+genreName+" Genre page. Did you click on the correct link?",
                genreMovieResultsPage.getTitle(), pageTitle);

        assertThatAtLeastOneMovieResultIsDisplayed(genreMovieResultsPage.getMovieResultsCount());
    }


    //Using just genre name
    @DataProvider(name="Genre")
    public Object[] genreName(){
        return new String[]{"Romance", "Western" };
    }

    @Test(dataProvider="Genre")
    public void shouldHaveAtLeastOneMovieInGenreResults(String genreName){

        GenreBasedMovieResultsPage genreMovieResultsPage = top250ResultsPage.clickOnGenre(genreName);

        String expectedPageTitle = "Highest Rated "+genreName+" Feature Films";

        assertPageTitleForTheGenre("This is not "+genreName+" Genre page. Did you click on the correct link?",
                genreMovieResultsPage.getTitle(), expectedPageTitle);

        assertThatAtLeastOneMovieResultIsDisplayed(genreMovieResultsPage.getMovieResultsCount());
    }




    private void assertPageTitleForTheGenre(String message, String actualTitle, String expectedTitle) {
        Assert.assertTrue(actualTitle.contains(expectedTitle), message);
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed(int totalMovieResults) {
        Assert.assertTrue(totalMovieResults >= MINIMUM_RESULTS,
                "At least one movie result is expected for the selected genre");
    }
}
