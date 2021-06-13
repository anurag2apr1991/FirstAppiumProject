import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

public class AndroidUiAutomator {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        System.out.println("Session Id:" + driver.getSessionId());
        MobileElement myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver).
                findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")");
        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver).
                findElementsByAndroidUIAutomator("new UiSelector().className(\"Accessibility\")").get(1);

        //By myElement1 = MobileBy.AndroidUIAutomator("");
//      System.out.println("Element found is: " + myElement.getText());
//
//      myElement = (MobileElement) driver.findElementById("android:id/text1");
//      System.out.println("Element found is: " + myElement.getText());
//      myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
//      System.out.println("Element found is: " + myElement.getText());
//      myElement = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
//      System.out.println("Element found is: " + myElement.getText());
//      myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Access'ibility\"]");
//      System.out.println("Element found is: " + myElement.getText());
    }
}
