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
    @DisplayName("Check Alert")
    void alertTest() {
        sleep(10);
        step("Click on Alert button", () ->
                $(MobileBy.AccessibilityId("Alert Button")).click());

        step("Check for a Alert", () ->
                $(MobileBy.AccessibilityId("Alert")).should(Condition.appear));

        step("Check for a OK button", () ->
                $(MobileBy.AccessibilityId("OK")).should(Condition.appear));

        step("Close Alert", () -> {
            $(MobileBy.AccessibilityId("OK")).click();
            $(MobileBy.AccessibilityId("OK")).should(Condition.disappear);
        });
    }

    @Test
    @DisplayName("Check input Text")
    void inputTextTest() {
        sleep(10);
        step("Click on Text button", () ->
                $(MobileBy.AccessibilityId("Text Button")).click());

        String inputValue = "Good day!";
        step("Enter the text", () ->
                $(MobileBy.AccessibilityId("Text Input")).val(inputValue).pressEnter());

        step("Check the displayed Text", () ->
                $(MobileBy.AccessibilityId("Text Output")).shouldHave(Condition.text(inputValue)));
    }
}
