package com.vigneshp.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vigneshp.pages.AbstractPage;

public class DashboardPage extends AbstractPage{

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id="monthly-earning")
    private WebElement monthlyEarningsElement;

    @FindBy(id="annual-earning")
    private WebElement annualEarningsElement;

    @FindBy(id="profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id="available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css="#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id="dataTable_info")
    private WebElement searchResultCountElement;

    @FindBy(css="img.img-profile")
    private WebElement userProfilePictureElemet;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;
    
    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningsElement));
        return this.monthlyEarningsElement.isDisplayed();
    }

    public String getMonthlyEarning(){
        return this.monthlyEarningsElement.getText();
    }

    public String getAnnualEarning(){
        return this.annualEarningsElement.getText();
    }

    public String getProfitMargin(){
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory(){
        return this.availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword){
        this.searchInput.clear();
        this.searchInput.sendKeys(keyword);
    }

    public int getSearchResultsCount(){
        String resultsText=this.searchResultCountElement.getText();
        String arr[]=resultsText.split(" ");
        int count=Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }

    public void logout(){
        this.userProfilePictureElemet.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.modalLogoutButton));
        this.modalLogoutButton.click();
    }
}
