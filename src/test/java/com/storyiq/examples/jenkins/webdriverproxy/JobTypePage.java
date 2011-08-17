package com.storyiq.examples.jenkins.webdriverproxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobTypePage {

	private final WebDriver driver;

	@FindBy(how = How.NAME, using = "name")
	private WebElement jobName;

	@FindBy(how = How.NAME, using = "mode")
	private WebElement freeStyleJob;

	public JobTypePage(WebDriver driver) {
		this.driver = driver;
		(new WebDriverWait(driver, 10)).until(new ElementReady(By.name("name")));
 	}

	public JobConfigPage createFreeStyleJob(String name) {
		jobName.sendKeys(name);
		freeStyleJob.click();
		freeStyleJob.submit();
		return PageFactory.initElements(driver, JobConfigPage.class);
	}
}
