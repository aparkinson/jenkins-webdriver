package com.storyiq.examples.jenkins.webdriverproxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class ValueChanged implements ExpectedCondition<Boolean> {

	private final String value;
	private final By selector;

	public ValueChanged(String value, By selector) {
		this.value = value;
		this.selector = selector;
	}

	public Boolean apply(WebDriver d) {
		WebElement codeMirror = d.findElement(selector);
        return codeMirror.getText().equals(value);
    }

}
