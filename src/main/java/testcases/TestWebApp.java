package testcases;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class TestWebApp {
    // test webapp
    public  static AppiumDriverLocalService service;
    public  static void main (String[] args) throws InterruptedException{
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium3.log")));
        service.start ();

             System.setProperty("webdriver.gecko.driver", "/Users/suaadbatis/Desktop/BySuaadBatis/geckodriver");
             WebDriver driver = new FirefoxDriver();
             driver.get ("http://google.com");
             driver.manage ().window ().maximize ();
             driver.findElement(By.id("q")).sendKeys ("Suaad Batis");
             //driver.quit ();
             Thread.sleep (4000);
          service.stop ();
        }


}
