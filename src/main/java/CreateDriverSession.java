import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch (platformName) {

            case "Android":
             //   caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //     already declared above
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
             //   caps.setCapability("newCommandTimeout", 300);

                //Autolaunch the AVD
                //caps.setCapability("avd", "");
                //caps.setCapability("avdLaunchTimeout", 180000);

                //  Launch at specific activity - if it is directly accessible
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                caps.setCapability(MobileCapabilityType.APP, andAppUrl);
                return new AndroidDriver(url, caps);

            //<---iOS-->
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "3FEF9D39-7F9A-454F-8599-9AE62AA2CA7F");
                 /*paid account capability
                caps.setCapability("xcodeOrgId","");
                caps.setCapability("xcodeSigningId","iPhone Developer");
                */
                caps.setCapability("simulatorStartupTimeout", 180000);//iOS Simulator start - helpful in CI/CD timeline
                //
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "UICatalog-iphonesimulator.app";
                //caps.setCapability(MobileCapabilityType.APP,iOSAppUrl);
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                return new IOSDriver(url, caps);
            default:
                throw new IllegalStateException("Unexpected value: " + platformName);
        }

    }
}
