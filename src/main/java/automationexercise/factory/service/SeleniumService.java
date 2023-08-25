package automationexercise.factory.service;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class SeleniumService {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static File driverLocation;


    @BeforeClass
    public static void installDriver() {
        SeleniumManagerOutput.Result location = DriverFinder.getPath(
                ChromeDriverService.createDefaultService(), new ChromeOptions());
        driverLocation = new File(location.driverPath);
    }

    // inicia o browser
    public void initChromeDriver(String url){
        ChromeDriverService serviceChrome = new ChromeDriverService.Builder()
                .usingDriverExecutable(driverLocation)
                .usingPort(1234)
                .build();
        driver = new ChromeDriver(serviceChrome);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();

    }

    @After
    public void quit() {
        driver.quit();
    }

}
