package com.storyiq.examples.jenkins.webdriverproxy;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

public class JobManagementTest {

	@Test
	public void testCreateNewJob() {		
		final FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "localhost");
		profile.setPreference("network.proxy.http_port", 8080);
		profile.setPreference("network.proxy.no_proxies_on", "");		
		
		final WebDriver driver = new FirefoxDriver(profile);		
		driver.get("http://localhost/jenkins/");		
		
		final JenkinsNavigation navigation = PageFactory.initElements(driver, JenkinsNavigation.class);
		navigation.newJob().createFreeStyleJob("example").setDescription("Hello World");		
		driver.close();		
	}
}
