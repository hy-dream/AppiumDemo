package page;
import driver.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class MainPage {
    By profile = By.id("user_profile_icon");
    By search = By.id("tv_search");
    By zixuan = By.xpath("//*[@text='自选']");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile() {
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearch() {
        Driver.getCurrentDriver().findElement(search).click();
        return new SearchPage();
    }

    public ZiXuanPage gotoZiXuan(){
        waitAndFindElement(zixuan);
        return new ZiXuanPage();
    }

    //首页上自选这类的按钮，坐标会随着页面加载发生变化，等位置固定后再点击
    void waitAndFindElement(By element){
        WebElement e;
        Point p0;
        try {
            Driver.getCurrentDriver().findElement(element);
        }finally {
            e= Driver.getCurrentDriver().findElement(element);
            p0 = e.getLocation();
        }
        for (int i = 0; i < 5; i++) {
            e=Driver.getCurrentDriver().findElement(element);
            Point p1 = e.getLocation();
            System.out.println("****************************************************************************");
            System.out.println(p0.toString());
            System.out.println(p1.toString());
            if (p0.equals(p1)) {
                e.click();
                break;
            } else {
                p0 = p1;
                try {
                    sleep(1000);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}