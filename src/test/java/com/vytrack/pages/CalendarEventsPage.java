package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage{
    
    @FindBy(xpath="//div[@class='btn btn-link dropdown-toggle']")
    public WebElement pageSubtitle;
    
    public String getSubtitleText(){
        return pageSubtitle.getText();
    }
    
}
