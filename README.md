# Automation project with Cucumber, Selenium and Java
This repository contains a Automation test for frontend with Selenium WebDriver.

## Table of contents
 - [Introduction]()
 - [Requirements]()
 - [Setup]()
 - [Running Test]()
 - [Web browser]()
 - [Project structure]()
 - [Reports]()

## Introduction
This project contains automation tests with the Selenium framework using the Java programming language.

The test cases in this project are profile creation, login and shopping cart on a demo e-commerce page.

## Requirements
- Development environment: This project was created in MacOS operating system
-	Programming language: This project was created using Java programming language. 
-	Required tools: 
    - JDK 8 or superior
    - Maven 
-	Required dependencies:
    - Selenium WebDriver
    - Cucumber
	- TestNG

## Setup
-	Clone this repository in your local machine
-	You can open the automation project in integrated development environment (IDE), for instance; IntelliJ IDEA, VScode, Eclipse, etc.
-	Instructions to install the required dependencies:
	```bash
    mvn install 
    ```

## Running Test
You can run the test of following way:
-	Run all tests
	```bash 
    mvn verify test
    ```
-	Run specific tests with parameters (runner, browser, and environment):
	```bash 
	mvn verify -Dtest=runnername -Denvironment=environment -Dbrowser=browser
	```
-	Run test in IDE
    - By default the test is run with chromedriver and qa environment found in the config.properties file

## Web Browser
The automation tests of this project currently run on the following web browsers
-	Chrome:  Google Chrome [Version 131](https://googlechromelabs.github.io/chrome-for-testing/)
-	Firefox: [geckodriver-V0.35.0](https://github.com/mozilla/geckodriver/releases)

## Project structure 
This project mainly uses the designed POM pattern but here the user actions (methods) are separated from the web elements in different classes.  Also, the project uses Cucumber and Gherkin integrated with Selenium WebDriver to create test cases. In general, the project consists of feature written in Gherkin language, step definitions in this file defines methods belonging to scenario and runner in which test cases execution is configured.

```bash
   📦selenium
 ┣ 📂src
 ┃ ┣ 📂main
 ┃┃ ┣ 📂java
 ┃┃ ┃ ┣ 📂actions
 ┃┃ ┃ ┣ 📂elements
 ┃┃ ┃ ┣ 📂utils
 ┃┃ ┃ ┃ ┣ 📂constants
 ┃┃ ┃ ┃ ┣ 📂dataoftest
 ┃┃ ┃ ┃ ┣ 📂drivers
 ┃┃ ┃ ┃ ┣ 📂hooks
 ┃┃ ┃ ┃ ┣ 📂others
 ┃ ┣ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┣ 📂runners
 ┃ ┃ ┣ 📂stepdefinitions
 ┃ ┃ ┣ 📂resources
 ┃ ┃ ┃ ┣ 📂drivers
 ┃ ┃ ┃ ┣ 📂features
 ┣ 📂target
 ┣ 📜pom.xml
 ┣ 📜config.properties
```

### Key Folders and Files
-	`src/main/java/actions`: this folder contains the classes that have the methods in which the user's actions are simulated.
-	`src/main/java/elements`: this folder contains of classes that have web elements from the DOM

-	`src/main/java/utils/constants`: this folder contains the classes that have constant data used in the test cases

-	`src/main/java/utils/dataoftest`: this folder contains the classes that have data created during the execution of the test cases

-	`src/main/java/utils/drivers`: this folder contains the classes that have the configuration of the browser drivers

-	`src/main/java/utils/hooks`: this folder contains the classes that have the pre-run configurations of the test cases

-	`src/main/java/utils/others`: this folder contains the classes that have the methods, data, settings, etc. Used in test cases

-	`src/main/java/utils/randomdata`: this folder contains the classes that have methods that create random data for the test cases

-	`src/test/java/runners`: this folder contains the classes that have the configuration for the execution of the test scripts

-	`src/test/java/stepdefinitions`: this folder contains the classes that have the test case steps. It also contains the @Given, @When and @Then annotations.

-	`src/test/resources/features`: this folder contains the files that have the characteristics of the test scenarios for the test cases.

-	`config.properties`: this file contains configuration data that is used in test scripts

## Reports
This project automatically generates Cucumber reports in HTML format these are located in the following paths:
-	`target/cucumber-html-reports`
-	`target/cucumber-reports`

## Built with
- [Cucumber framework](https://cucumber.io/)
- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- [Java](https://www.java.com/es/)

## Author
[@Santiago Quintero](https://github.com/stiagoq)
