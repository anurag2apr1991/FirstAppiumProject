import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();

        // driver.terminateApp("",new AndroidTerminateApplicationOptions().withTimeout());
        Thread.sleep(5000);
        //   driver.runAppInBackground(Duration.ofMillis(5000));
        //  driver.activateApp("",AndroidA);
        // System.out.println(driver.isAppInstalled(""));
        String appUrl = System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "main" + File.separator +
                "resources" + File.separator + "ApiDemos-debug.apk";
        //  driver.installApp(appUrl,new AndroidInstallApplicationOptions().withReplaceEnabled());

        System.out.println(driver.queryAppState("")); // to check the state of the application
    }
}
