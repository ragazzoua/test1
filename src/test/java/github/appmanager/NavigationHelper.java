package github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton(){
        driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).click();
    }

}
