package testcases;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class TestScroll {



    // test webapp
    public  static AppiumDriverLocalService service;
    public  static void main (String[] args) throws InterruptedException{
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium6 .log")));
        service.start ();

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability (CapabilityType.BROWSER_NAME, "Chrome");

        capabilities.setCapability ("deviceName", "Huaweip10lite");
        capabilities.setCapability ("appPackage", "com.html5test.webview");
        capabilities.setCapability ("appActivity", "main.java.mainActivity");

        //driver.quit ();
        Thread.sleep (4000);
        service.stop ();
    }
}
