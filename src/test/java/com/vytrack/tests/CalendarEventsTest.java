package com.vytrack.tests;

import com.vytrack.TestBase;
import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarEventsTest extends TestBase {
    @Test
    public void TC001_VerifyOptionsDisplayed(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
    
        DashboardPage dashboardPage =new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
    
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String subTitleText=calendarEventsPage.pageSubtitle.getText();
    
        Assert.assertEquals(subTitleText,"Options","verify subtitle");
        
        
    }
}
