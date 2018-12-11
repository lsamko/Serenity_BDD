package net.serenitybdd.tutorial.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.tutorial.model.Category;
import net.serenitybdd.tutorial.steps.NavigatingUser;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

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
        mark.navigatesToCategory(Category.Motors);

        //Then
        mark.shouldSeePageTitleContaining("New and used cars");

    }
}
