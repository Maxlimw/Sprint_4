package ru.practicum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentalPage {
    private final WebDriver driver;
    private final By dateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalDurationSel = By.className("Dropdown-placeholder");
    private final By rentalDuration = By.xpath(".//div[contains(text(), 'шестеро суток')]");
    private final By checkBoxGreyScooter = By.xpath(".//label[@for='grey']");
    private final By checkBoxBlackScooter = By.xpath(".//label[@for='black']");
    private final By commentForCourier = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    private final By confirmationButton = By.xpath(".//button[contains(text(), 'да')]");
    private final By popUpOrder = By.className("Order_Modal__YZ-d3");
    public AboutRentalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryDate(String date) {
        driver.findElement(dateDelivery).sendKeys(date);
    }

    public void openRentalDurationDropdown() {
        driver.findElement(rentalDurationSel).click();
    }

    public void selectRentalDuration() {
        driver.findElement(rentalDuration).click();
    }

    public void selectScooterColor(String color) {
        if (color.equalsIgnoreCase("grey")) {
            driver.findElement(checkBoxGreyScooter).click();
        } else if (color.equalsIgnoreCase("black")) {
            driver.findElement(checkBoxBlackScooter).click();
        }
    }

    public void enterCourierComment(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmationButton() {
        driver.findElement(confirmationButton).click();
    }

    public boolean isRentalPopUpVisible() {
        return driver.findElement(popUpOrder).isDisplayed();
    }

    public void fillRentalForm(String date, String colour, String comment) {
        enterDeliveryDate(date);
        clickOrderButton();
        openRentalDurationDropdown();
        selectRentalDuration();
        selectScooterColor(colour);
        enterCourierComment(comment);
        clickOrderButton();
    }
}
