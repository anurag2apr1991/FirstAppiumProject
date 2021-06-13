import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriverSession {

    public static void main(String[] args) throws MalformedURLException {
//        DesiredCapabilities capabAndroid = new DesiredCapabilities();
//        capabAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
//        capabAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
//        capabAndroid.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        capabAndroid.setCapability("newCommandTimeout", 300);
//
//        //Autolaunch the AVD
//        capabAndroid.setCapability("avd", "");
//        capabAndroid.setCapability("avdLaunchTimeout", 180000);
//        //
//
//        capabAndroid.setCapability(MobileCapabilityType.APP, appUrl);
//
//        //  Launch at specific activity - if it is directly accessible
////        capabAndroid.setCapability("appPackage","io.appium.android.apis");
////        capabAndroid.setCapability("appActivity",".accessibility.CustomViewAccessibilityActivity");
//        URL url = new URL("http://0.0.0.0:4723/wd/hub");
//        AppiumDriver driver = new AndroidDriver(url, capabAndroid);
//        System.out.println("session id: " + driver.getSessionId()); // fetch the session id to attach to a session


//<---iOS-->
        DesiredCapabilities capsIOS = new DesiredCapabilities();
        capsIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capsIOS.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
        capsIOS.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capsIOS.setCapability(MobileCapabilityType.UDID, "3FEF9D39-7F9A-454F-8599-9AE62AA2CA7F");
        /*//paid account capability
        capsIOS.setCapability("xcodeOrgId","");
        capsIOS.setCapability("xcodeSigningId","iPhone Developer");
        //*/

        //iOS Simulator start - helpful in CI/CD timeline
        capsIOS.setCapability("simulatorStartupTimeout",180000);
        //
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "UICatalog-iphonesimulator.app";
        capsIOS.setCapability(MobileCapabilityType.APP,appUrl);
      //  capsIOS.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
       AppiumDriver driver = new IOSDriver(url, capsIOS);

    }
}

