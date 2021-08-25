package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
        String login = credentials.login();
        String password = credentials.password();
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = format("https://%s:%s@%s",login, password,System.getProperty("selenoid"));
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;

    }
    @AfterEach
    void tearDown (){
        Attach.screenshotAs("Скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
