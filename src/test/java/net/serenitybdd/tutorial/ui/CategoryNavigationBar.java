package net.serenitybdd.tutorial.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.tutorial.model.Category;
import org.openqa.selenium.By;

public class CategoryNavigationBar extends PageObject {
    public void selectCategory(Category category) {
        $("*[role=navigation] *[role=list]").find(By.linkText(category.name())).click();
    }
}
