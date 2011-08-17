package com.storyiq.examples.jenkins.webdriverproxy;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class ElementReady implements ExpectedCondition<Boolean> {

	private final By selector;

	public ElementReady(By selector) {
		this.selector = selector;
	}

	public Boolean apply(WebDriver d) {
		final WebElement codeMirror = d.findElement(selector);
        return true;
    }

}
