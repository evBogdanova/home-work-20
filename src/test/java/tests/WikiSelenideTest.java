package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@Tag("selenide_ios")
@DisplayName("Check UI elements in sample ios app (SELENIDE)")
public class WikiSelenideTest extends TestBase{
    @Test
    @DisplayName("Check Text element in sample ios app")
    void searchTest() {
    }
}
