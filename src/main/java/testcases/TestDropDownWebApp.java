//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
// how to copy links

package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TestDropDownWebApp {
    public static AndroidDriver<WebElement> driver;
    public  static AppiumDriverLocalService service;


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium5.log")));
        service.start ();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("deviceName", "Huaweip10lite");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("http://wikipedia.org");
        WebElement dropdown = driver.findElement(By.id("searchLanguage"));
        Select select = new Select(dropdown);
        select.selectByValue("hi");
        List<WebElement> values = dropdown.findElements(By.tagName("option"));
        System.out.println(values.size());
        Iterator var7 = values.iterator();

        WebElement block;
        while(var7.hasNext()) {
            block = (WebElement)var7.next();
            System.out.println(block.getAttribute("lang"));
        }

        System.out.println("----Printing links-------");
        block = driver.findElement(By.cssSelector(".other-projects"));// new inspector type
        List<WebElement> links = block.findElements(By.tagName("a"));
        System.out.println(links.size());
        Iterator var9 = links.iterator();

        while(var9.hasNext()) {
            WebElement link = (WebElement)var9.next();
            System.out.println(link.getAttribute("href") + "----" + link.getText());
        }

        Thread.sleep(2000L);
        driver.quit();
        service.stop();
    }
}
