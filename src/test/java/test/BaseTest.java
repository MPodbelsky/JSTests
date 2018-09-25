package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver browser;
    @BeforeMethod
    @Parameters("testName")
    public void beforeMethod(@Optional("file:///C:/Users/Matthews/IdeaProjects/testhometaskjs/%D1%81%D0%BE%D0%B1%D0%B5%D1%81.html") String testName){
        browser = new ChromeDriver();
        browser.get(testName);
        }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }
}
