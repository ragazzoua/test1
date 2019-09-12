package github.appmanager;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    private String browser;
    private NavigationHelper navigationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

//        if (browser.equals(BrowserType.FIREFOX)) {
//            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
//            driver = new FirefoxDriver();
//        } else if (browser.equals(BrowserType.CHROME)) {
//            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
//            driver = new ChromeDriver();
//        } else if (browser.equals(BrowserType.IE)) {
//            WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
//            driver = new InternetExplorerDriver();
//        }
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        navigationHelper = new NavigationHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\test\\screenshot.png"));
    }
}

