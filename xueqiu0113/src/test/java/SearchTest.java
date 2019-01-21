import driver.GlobleConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    static  MainPage mainPage;
    static  SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        searchPage=mainPage.start().gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({"pdd,拼多多","alibaba,阿里巴巴"})
     void searchSucced(String keyword,String expected){
        String actual=searchPage.search(keyword).getStockList().get(0);
        assertThat(actual,equalTo(expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/xueqiu.csv",numLinesToSkip = 1)
    void searchSuccedfromFile(String keyword,String expected){
        String actual=searchPage.search(keyword).getStockList().get(0);
        assertThat(actual,equalTo(expected));
    }

    @ParameterizedTest
    @ArgumentsSource(GlobleConfig.class)
    void searchSuccedFromConfig(String keyword,String expected){
        String actual=searchPage.search(keyword).getStockList().get(0);
        assertThat(actual,equalTo(expected));
    }

    @Test
     void addSelectTest(){
        ArrayList<String> actual=searchPage.search("alibaba").addSelected();
        assertThat(actual,hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }
}
