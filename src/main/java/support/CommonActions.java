package support;

import Driver.DriverFactory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static java.time.Duration.ofMillis;

public class CommonActions {
    public static boolean isElementPresent(WebElement element) {
        try {
            if (element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean isElementPresentt(WebElement element, String Elename) {
        try {
            if (element.isDisplayed()) {
                System.out.println(Elename + " is displayed");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void fingerSwipe(int startX, int startY, int endX, int endY, long timeInMillis) {
        PointerInput touchAction = new PointerInput(PointerInput.Kind.TOUCH, "touchAction");
        Interaction moveToStart = touchAction.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY);
        Interaction pressDown = touchAction.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
        Interaction moveToEnd = touchAction.createPointerMove(ofMillis(timeInMillis), PointerInput.Origin.viewport(), endX, endY);
        Interaction pressUp = touchAction.createPointerUp(PointerInput.MouseButton.LEFT.asArg());
        Sequence swipe = new Sequence(touchAction, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);
        DriverFactory.getDriver().perform(Arrays.asList(swipe));
    }

    public static void WaitTillElementisvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fingerSwipee(int startX, int startY, int endX, int endY, long timeInMillis) {
        if (ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("ios")) {
            PointerInput touchAction = new PointerInput(PointerInput.Kind.TOUCH, "touchAction");
            Interaction moveToStart = touchAction.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY);
            Interaction pressDown = touchAction.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
            Interaction moveToEnd = touchAction.createPointerMove(ofMillis(timeInMillis), PointerInput.Origin.viewport(), endX, endY);
            Interaction pressUp = touchAction.createPointerUp(PointerInput.MouseButton.LEFT.asArg());
            Sequence swipe = new Sequence(touchAction, 0);
            swipe.addAction(moveToStart);
            swipe.addAction(pressDown);
            swipe.addAction(moveToEnd);
            swipe.addAction(pressUp);
            ((IOSDriver) DriverFactory.getDriver()).perform(Arrays.asList(swipe));
        } else if (ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("android")) {
            PointerInput touchAction = new PointerInput(PointerInput.Kind.TOUCH, "touchAction");
            Interaction moveToStart = touchAction.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY);
            Interaction pressDown = touchAction.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
            Interaction moveToEnd = touchAction.createPointerMove(ofMillis(timeInMillis), PointerInput.Origin.viewport(), endX, endY);
            Interaction pressUp = touchAction.createPointerUp(PointerInput.MouseButton.LEFT.asArg());
            Sequence swipe = new Sequence(touchAction, 0);
            swipe.addAction(moveToStart);
            swipe.addAction(pressDown);
            swipe.addAction(moveToEnd);
            swipe.addAction(pressUp);
            ((AppiumDriver) DriverFactory.getDriver()).perform(Arrays.asList(swipe));
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        //RunLog.logStepStatus(Wrapper.wrapText("TIME >> isElementDisplayed >> Verifying  >>  " + LocalDateTime.now()));
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            //RunLog.logStepStatus(Wrapper.wrapText("TIME >> isElementDisplayed >> After Verifying  >>  " + LocalDateTime.now()));
            return false;
        }
    }

    public static void scrollUp() {
        Dimension size = DriverFactory.getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2); // Start scrolling at 50% down the screen
        int endY = (int) (size.height * 0.4); //  End scrolling from 80% down the screen
        fingerSwipe(startX, startY, startX, endY, 500); // You can adjust the duration (in milliseconds) if needed
    }

    public static void scrollDown() {
        Dimension size = DriverFactory.getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8); // Start scrolling from 80% down the screen
        int endY = (int) (size.height * 0.5); // End scrolling at 50% down the screen
        fingerSwipe(startX, startY, startX, endY, 500); // You can adjust the duration (in milliseconds) if needed
    }

    public static void scrollUntilElementDisplays(WebElement element, int count, String side) {
        int initialCount = 0;
        while (!isElementDisplayed(element)) {
            switch (side.toLowerCase()) {
                case "up":
                    scrollUp();
                    break;
                case "down":
                    scrollDown();
                    break;
                default:
                    break;
            }
            if (count == initialCount)
                break;
            initialCount++;
        }
    }

    public static void clickAtPoint(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverFactory.getDriver().perform(Collections.singletonList(tap));
    }

    public static void WaitTillElementisClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void SwipeByCoordinates(int StartX, int StartY, int EndX, int EndY) {
        System.out.println("Initiating Swipe");
        PointerInput Finger = new PointerInput(PointerInput.Kind.TOUCH, "Finger");

        Interaction movetoStart = Finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), StartX, StartY);
        Interaction movedown = Finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg());

        Interaction movetoEnd = Finger.createPointerMove(Duration.ofMillis(900), PointerInput.Origin.viewport(), EndX, EndY);
        Interaction moveUp = Finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg());

        Sequence swiper = new Sequence(Finger, 1);
        swiper.addAction(movetoStart);
        swiper.addAction(movedown);
        swiper.addAction(movetoEnd);
        swiper.addAction(moveUp);

        ((AppiumDriver) DriverFactory.getDriver()).perform(Arrays.asList(swiper));

    }

    public static void SwipeUp(int val) {

        Dimension Screensize = DriverFactory.getDriver().manage().window().getSize();
        int Startx = (Screensize.getWidth() / 2);
        int StartY = (Screensize.getHeight() * 3 / 4);
        int EndX = (Screensize.getWidth() / 2);
        int EndY = (Screensize.getHeight() / 2);
        int start = 0;
        while (start <= val) {
            SwipeByCoordinates(Startx, StartY, EndX, EndY);
            System.out.println("Swiping up");
            start++;
        }
    }
}
