import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;
import page.ZiXuanPage;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ZiXuanTest {

    static MainPage mainPage;
    static ZiXuanPage ziXuanPage;

    @BeforeAll
    static void beforeAll(){
        ziXuanPage=mainPage.start().gotoZiXuan();
    }

    @ParameterizedTest
    @CsvSource({"pdd,拼多多", "alibaba,阿里巴巴"})
    void addStock(String keyword, String stockName) {
        SearchPage searchPage = ziXuanPage.gotoSearch().search(keyword);
        searchPage.addSelected();
        searchPage.cancel();
        String firstZiXuanStock = ziXuanPage.getZiXuanList().get(0);
        assertThat(firstZiXuanStock, equalTo(stockName));
    }
    @ParameterizedTest
    @CsvSource({"拼多多", "阿里巴巴"})
    void removeStock(String stock){
        ziXuanPage.removeSelect(stock);
        ArrayList<String> stocklist=ziXuanPage.getZiXuanList();
        assertThat(stocklist,not(hasItem(stock)));
    }


}