package driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GlobleConfig implements ArgumentsProvider {
    public AppiumConfig appcon;
    public XueQiuConfig xuecon;
    public TestDataConf testdata;

    static GlobleConfig load(String filePath){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            GlobleConfig config = mapper.readValue(GlobleConfig.class.getResource(filePath),
                    GlobleConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        GlobleConfig gcon=GlobleConfig.load("/data/globalConfig.yaml");
        return Stream.of(arguments(gcon.testdata.input.get(0), gcon.testdata.expected.get(0)),
                arguments(gcon.testdata.input.get(1), gcon.testdata.expected.get(1)));
    }

}
