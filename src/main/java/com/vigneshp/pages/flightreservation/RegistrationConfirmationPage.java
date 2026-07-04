package com.vigneshp.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vigneshp.pages.AbstractPage;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id="go-to-flights-search")
    private WebElement flightSearch;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    public void goToFlightSearch(){
        this.flightSearch.click();
    }

    public String getFirstName(){
    return this.firstNameElement.getText();
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightSearch));
        return this.flightSearch.isDisplayed();
    }

}
