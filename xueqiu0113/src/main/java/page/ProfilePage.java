package page;
import driver.Driver;
import org.openqa.selenium.By;

public class ProfilePage {
    By login=By.id("tv_login");
    public LoginPage gotoLogin(){
        Driver.getCurrentDriver().findElement(login).click();
        return new LoginPage();
    }
}
