import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndLockAndUnlockDevice {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ((AndroidDriver) driver).lockDevice(Duration.ofMillis(5000)); //lock device
        System.out.println(((AndroidDriver<?>) driver).isDeviceLocked());
        ((AndroidDriver)driver).unlockDevice(); // unlock device

     //   ((IOSDriver)driver).lockDevice(Duration.ofSeconds());
    }
}
//lock, unlock, isDeviceLocked