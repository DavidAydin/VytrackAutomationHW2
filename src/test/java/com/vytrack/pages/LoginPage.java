package com.vytrack.pages;

import com.vytrack.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    
    @FindBy(id="prependedInput")
    WebElement userNameInput;
    
    @FindBy(id="prependedInput2")
    WebElement passwordInput;
    
    @FindBy(id="_submit")
    WebElement loginButton;
    
    public void loginAsStoreManager(){
        userNameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginButton.click();
        
        
    }
    
}


