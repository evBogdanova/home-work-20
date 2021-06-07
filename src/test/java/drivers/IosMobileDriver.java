package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.BrowserstackHelper;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.iosConfig;


public class IosMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return getIosDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "qa_guru_20");
        capabilities.setCapability("build", "Ios");
        capabilities.setCapability("name", "MobileTests");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", iosConfig.device());
        capabilities.setCapability("os_version", iosConfig.osVersion());
        capabilities.setCapability("app", iosConfig.app());

        return new IOSDriver(BrowserstackHelper.getBrowserstackUrl(), capabilities);
    }
}
