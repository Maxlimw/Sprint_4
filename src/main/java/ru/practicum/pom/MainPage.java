package ru.practicum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;
    private final By topOrderButton = By.className("Button_Button__ra12g");
    private final By bottomOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getQuestionNumber(int questionIndex) {
        return By.id("accordion__heading-" + questionIndex);
    }

    public By getAnswerLocator(int answerIndex) {
        return By.id("accordion__panel-" + answerIndex);
    }

    public void clickQuestionNumber(int questionIndex) {
        WebElement element = driver.findElement(getQuestionNumber(questionIndex));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}
