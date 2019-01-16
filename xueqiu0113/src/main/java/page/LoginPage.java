package page;
import driver.Driver;
import org.openqa.selenium.By;

public class LoginPage {
    By 手机及其他登录=By.id("tv_login_by_phone_or_others");
    By 手机号=By.id("register_phone_number");
    By 验证码=By.id("register_code");
    By 登录=By.id("button_next");
    By 邮箱手机号密码登录=By.id("tv_login_with_account");
    By phoneNumber=By.id("login_account");
    By PWD=By.id("login_password");
    By 错误提示=By.id("md_content");
    By 确定=By.id("md_buttonDefaultPositive");
    By 关闭=By.id("iv_close");

    String message;

    public LoginPage loginViaPhoneandcodeFailed(String phone,String verifyCode){
        Driver.getCurrentDriver().findElement(手机及其他登录).click();
        Driver.getCurrentDriver().findElement(手机号).sendKeys(phone);
        Driver.getCurrentDriver().findElement(验证码).sendKeys(verifyCode);
        Driver.getCurrentDriver().findElement(登录).click();
        message=Driver.getCurrentDriver().findElement(错误提示).getText();
        Driver.getCurrentDriver().findElement(确定).click();
        return this;
    }

    public LoginPage loginViaPhoneandPWDFailed(String phone,String password){
        Driver.getCurrentDriver().findElement(手机及其他登录).click();
        Driver.getCurrentDriver().findElement(邮箱手机号密码登录).click();
        Driver.getCurrentDriver().findElement(phoneNumber).sendKeys(phone);
        Driver.getCurrentDriver().findElement(PWD).sendKeys(password);
        Driver.getCurrentDriver().findElement(登录).click();
        message=Driver.getCurrentDriver().findElement(错误提示).getText();
        Driver.getCurrentDriver().findElement(确定).click();
        return this;

    }
    public String getMessage(){
        return message;
    }

    public ProfilePage backtoProfile(){
        Driver.getCurrentDriver().findElement(关闭).click();
        return new ProfilePage();
    }
}
