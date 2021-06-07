package tests;

import com.codeborne.selenide.Configuration;
import drivers.IosMobileDriver;
import helpers.AttachmentHelper;
import helpers.BrowserstackHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.getSessionId;


public class TestBase {
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = IosMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void allureAttachments() {
        String sessionId = getSessionId();
        AttachmentHelper.screenshotAs("Last screenshot");
        AttachmentHelper.attachAsText("Browserstack build link", BrowserstackHelper.getBSPublicLink(sessionId));
        closeWebDriver();
        AttachmentHelper.attachVideo(sessionId);
    }

}
