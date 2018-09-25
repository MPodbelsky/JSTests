package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {
    private  WebDriver browser;
    public Alert alert;

    public AlertPage(WebDriver browser) {
        this.browser=browser;
        alert = (new WebDriverWait(browser, 10))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void dataAlert(String param) {
        alert = browser.switchTo().alert();
        alert.sendKeys(param);
        alert.accept();
    }
}
