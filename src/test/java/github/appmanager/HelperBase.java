package github.appmanager;

import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }
}
