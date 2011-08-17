package com.storyiq.examples.jenkins.webdriverproxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobConfigPage {
	
	final private WebDriver driver;

	public JobConfigPage(WebDriver driver) {
		this.driver = driver;
		(new WebDriverWait(driver, 10)).until(new ElementReady(By.name("description")));
	}


	public void setDescription(final String text) {
		WebElement descriptionField = driver.findElement(By.cssSelector("div.CodeMirror textarea"));
		descriptionField.sendKeys(text);	
		(new WebDriverWait(driver, 10)).until(new ValueChanged(text, By.cssSelector("div.CodeMirror-scroll pre span")));		
		descriptionField.submit();
	}
}
