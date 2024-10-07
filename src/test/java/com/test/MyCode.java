package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class MyCode {
    @Test
    void tap() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("9");
        options.setDeviceName("cpv");
        options.setAutomationName("UiAutomator2");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppPackage("com.swaglabsmobileapp");
//        options.setAppActivity("com.android.calculator2.Calculator");
//        options.setAppPackage("com.android.calculator2");
//        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().window().getSize();
        Thread.sleep(3000);
        WebElement openMenu = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"standard_user\"]"));
        tap(driver, openMenu);
        swipeUp(driver);
    }

    private void tap(AndroidDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Dimension phoneSize = driver.manage().window().getSize();
        Point point = new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(sequence));
        System.out.println();
    }

    private void swipeUp(AndroidDriver driver) {
        Dimension screen = driver.manage().window().getSize();
        Point point1 = new Point(screen.getWidth() / 2, screen.getHeight() * 3 / 4);
        Point point2 = new Point(screen.getWidth() / 2, screen.getHeight() / 4);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), point2))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(sequence));
        System.out.println();
    }

    @Test
    public void BrowserTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("cpv")
                .setPlatformVersion("9")
                .withBrowserName("chrome");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.getCurrentUrl();

    }
}
