import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ApiTests {

    @Test
    public void apiTest1(){

        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(config.baseURL()).isEqualTo("https://github.com/");
        assertThat(config.token()).isEqualTo("secret123");
    }
}
