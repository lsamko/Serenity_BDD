package net.serenitybdd.tutorial.steps;

import net.serenitybdd.tutorial.model.Category;
import net.serenitybdd.tutorial.ui.CategoryNavigationBar;
import net.serenitybdd.tutorial.ui.CurrentPage;
import net.serenitybdd.tutorial.ui.EbayHomePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;


public class NavigatingUser {

    EbayHomePage ebayHomePage;
    CurrentPage currentPage;
    CategoryNavigationBar categoryNavigationBar;

    @Step
    public void isOnTheHomePage(){
        ebayHomePage.open();
    }

    @Step
    public void shouldSeePageTitleContaining(String expectedTitle) {
        assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
    }

    @Step
    public void navigatesToCategory(Category category) {
        categoryNavigationBar.selectCategory(category);
    }
}
