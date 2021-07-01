import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class iOSInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By activityIndicators = MobileBy.AccessibilityId("ActivityIndicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(5000);
        //driver.terminateApp("bundleID of iOS APP"); //Terminate the app
        String iOSAppUrl = System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" +
                File.separator + "UICatalog-iphonesimulator.app";
        //driver.installApp(iOSAppUrl);  //install the app
        driver.runAppInBackground(Duration.ofMillis(5000)); //Move to background
        driver.activateApp("Activating settings APP");
        Thread.sleep(5000);
        driver.activateApp("Activating our app");

        driver.queryAppState(""); //query the start if active or inactive
        driver.resetApp();//reset the app

        //Javascript method to interact with XUITest

        Map<String, Object> params = new HashMap<>();
        params.put("bundleId","com.example.apple-sampleCode.UICatalog");
        final boolean isInstalled = (boolean) driver.executeScript("",params);
        System.out.println(isInstalled);

    }
}
