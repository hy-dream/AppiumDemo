package driver;

import org.junit.jupiter.api.Test;

class XueqiuConfigTest {

    @Test
    void load(){
        GlobleConfig con= GlobleConfig.load("/data/globalConfig.yaml");
        System.out.println(con.xuecon.username);
        System.out.println(con.xuecon.app);
        System.out.println(con.appcon.cap);
        System.out.println(con.appcon.cap.get("deviceName"));
    }
}