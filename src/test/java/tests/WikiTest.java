package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@DisplayName("Check UI elements in sample ios app (SELENIDE)")
public class WikiTest extends TestBase {

    @Test
    @DisplayName("Check Text element in sample ios app")
    void searchTest() {
        sleep(10);
        step("Click on 'Alert' button", () ->
                $(MobileBy.AccessibilityId("Alert Button")).click());

        step("Check output field", () ->
                $(MobileBy.AccessibilityId("Text Output")).shouldHave(Condition.text("Alert")));
    }
}
