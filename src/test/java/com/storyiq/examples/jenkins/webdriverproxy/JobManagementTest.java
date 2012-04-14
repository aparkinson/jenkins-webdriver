package com.storyiq.examples.jenkins.webdriverproxy;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class JobManagementTest {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingChromeDriverExecutable(
                        new File("C:\\ChromeDriver\\chromedriver.exe"))
                .usingAnyFreePort().build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setProxyType(ProxyType.MANUAL);
        proxy.setHttpProxy("localhost:8080");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        driver = new RemoteWebDriver(service.getUrl(), capabilities);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testCreateNewJob() {
        driver.get("http://localhost/jenkins/");

        final JenkinsNavigation navigation = PageFactory.initElements(driver,
                JenkinsNavigation.class);
        navigation.newJob().createFreeStyleJob("example")
                .setDescription("Hello World");
        driver.close();
    }
}
