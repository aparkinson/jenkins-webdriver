package com.storyiq.examples.jenkins.webdriverproxy;

import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

public class JobManagementTest {

	@Test
    public void testCreateNewJob() {
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setProxyType(ProxyType.MANUAL);
        proxy.setHttpProxy("localhost:8080");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
		
        final WebDriver driver = new FirefoxDriver(capabilities);
		driver.get("http://localhost/jenkins/");		
		
		final JenkinsNavigation navigation = PageFactory.initElements(driver, JenkinsNavigation.class);
		navigation.newJob().createFreeStyleJob("example").setDescription("Hello World");		
		driver.close();		
	}
}
