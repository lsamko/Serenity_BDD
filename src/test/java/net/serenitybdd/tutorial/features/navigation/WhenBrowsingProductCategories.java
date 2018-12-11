package net.serenitybdd.tutorial.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.tutorial.model.Category;
import net.serenitybdd.tutorial.steps.NavigatingUser;
import net.serenitybdd.tutorial.tasks.NavigateTo;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.tutorial.model.Category.Motors;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCategories {

    @Steps
    NavigatingUser mark;

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleNavigateToMotorCategory(){
        //Given
        mark.isOnTheHomePage();

        //When
        mark.navigatesToCategory(Motors);

        //Then
        mark.shouldSeePageTitleContaining("New and used cars");
    }

    @Test
    public void shouldBeAbleToViwMotorProducts(){
        Actor mike = Actor.named("Mike");
        mike.can(BrowseTheWeb.with(browser));

        when(mike).attemptsTo(NavigateTo.theCategory(Motors));
        then(mike).should(seeThat(TheWebPage.title(), containsString("New and used cars")));
    }
}
