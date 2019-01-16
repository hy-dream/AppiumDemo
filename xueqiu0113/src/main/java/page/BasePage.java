package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    static WebElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(By.xpath("//*[@text='下次再说']")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }
}
