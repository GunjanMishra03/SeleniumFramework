package com.app.qa.testcases;

import com.app.qa.base.TestBase;
import com.app.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        System.out.println("Starting setUp method #1");
        initialization();
        loginPage= new LoginPage();
            }
            @Test(priority=1)
            public void loginPageTitleTest() throws InterruptedException {

               String title= loginPage.validateLoginPageTitle();

                Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, marketing campaigns and support.");

            }

            @AfterMethod
            public void tearDown(){
                System.out.println("Starting tearDown method #3");
        driver.quit();
            }
}
