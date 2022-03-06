package com.app.qa.pages;

import com.app.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase
{


   // page factory or object repository
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
            //div[@class='ui fluid large blue submit button']
    WebElement LoginBtn;
   // @FindBy(xpath ="//a[@href="https//register.cogmento.com/password/reset/request/"])
//            WebElement


    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String  validateLoginPageTitle(){
        return driver.getTitle();

}
 public HomePage login(String em, String pwd) throws IOException {
        email.sendKeys(em);
        password.sendKeys(pwd);
        LoginBtn.click();

        return new HomePage();

 }







}
