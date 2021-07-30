package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Activities')]")
    public WebElement activitiesTab;
    
    @FindBy(xpath="//span[contains(text(),'Calendar Events')]")
    public WebElement calendarEventsModule;
    
    
    @FindBy(xpath = "//div[@class='loader-mask shown']")
    @CacheLookup
    public  WebElement loaderMask;
    
    public void gotoActivities_CalendarEvents(){
        new Actions(Driver.get()).moveToElement(activitiesTab).perform();
        new Actions(Driver.get()).moveToElement(calendarEventsModule).perform();
        calendarEventsModule.click();
    }
    
    public void waitUntilLoaderScreenDisappear() {
        
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void navigateToModule(String tabName, String moduleName){
        String tabXpath = "//span[@class='title title-level-1'] [contains(text(),'"+tabName+"')]";
        WebElement tab = Driver.get().findElement(By.xpath(tabXpath));
        new DashboardPage().waitUntilLoaderScreenDisappear();
        String moduleXpath = "//span[@class='title title-level-2'] [contains(text(),'"+moduleName+"')]";
        WebElement module = Driver.get().findElement(By.xpath(moduleXpath));
    
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(tab).perform();
        
        actions.moveToElement(module).perform();
        module.click();
        
        
    }
    
}

