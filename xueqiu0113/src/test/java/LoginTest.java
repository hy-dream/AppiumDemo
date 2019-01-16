import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    //@Test
    @ParameterizedTest
    @CsvSource({"123456,12345678,手机号码填写错误","17600189896,23456788,用户名或密码错误"})
    public void LoginviaPhonePWDFailed(String phone,String PWD,String note){
        MainPage main=MainPage.start();
        ProfilePage profilePage=main.gotoProfile();
        LoginPage loginPage=profilePage.gotoLogin().loginViaPhoneandPWDFailed(phone,PWD);
        String actual=loginPage.getMessage();
        assertThat(actual,equalTo(note));
        //手机号码填写错误  用户名或密码错误
    }

    //@Test
    @ParameterizedTest
    @CsvSource({"17600189896,1234,验证码已过期"})
    public void LoginviaCodeFailed(String phone,String code,String note){
        MainPage main=MainPage.start();
        ProfilePage profilePage=main.gotoProfile();
        LoginPage loginPage=profilePage.gotoLogin().loginViaPhoneandcodeFailed(phone,code);
        String actual=loginPage.getMessage();
        assertThat(actual,equalTo(note));
    }
}
