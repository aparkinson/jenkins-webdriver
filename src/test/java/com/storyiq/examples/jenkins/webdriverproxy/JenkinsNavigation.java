package com.storyiq.examples.jenkins.webdriverproxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class JenkinsNavigation {

	private final WebDriver driver;
	
    @FindBy(how = How.LINK_TEXT, using = "New Job")
    private WebElement newJobAction;
    
    public JenkinsNavigation(WebDriver driver) {
		this.driver = driver;
	}

	public JobTypePage newJob() {
    	newJobAction.click();
    	return PageFactory.initElements(driver, JobTypePage.class);
    }
}
