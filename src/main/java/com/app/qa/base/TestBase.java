package com.app.qa.base;

import com.app.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\shekh\\IdeaProjects\\Framework\\"
                    + "src\\main\\java\\com\\app\\qa\\"
                    + "config\\config.properties");
            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\shekh\\Downloads\\chromedriver_win32\\"
                    + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("ff")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\shekh\\Downloads\\geckodriver_win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();




        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
