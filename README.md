# SampleTestingFramework
Selenium WebDriver framework containing tests for Login & Products page for
https://www.saucedemo.com/

## Pre requisites for running tests in command line:

- Java 8
- Maven 3.6.3
- Chrome driver. Download from https://chromedriver.chromium.org/downloads. 
  - For Windows : Save chromedriver.exe in c:\webdrivers\ or change this path which is hard coded in https://github.com/OneComQAAssignment/SampleTestingFramework/blob/main/src/main/java/com/one/framework/WebDriverFactory.java
  - For Mac : Already included in /driver folder for Mac.
- Allure Report : to display better visual of TestNG report.
  - How to install : https://docs.qameta.io/allure/#_installing_a_commandline
  - How to generate report : run this command 'allure serve allure-results/' and it will open a browser window to display the report

Run 'mvn clean install -DskipTests' to build the project 

## Run tests for Windows
In target folder run :

java -cp PocForOneCom-1.0-SNAPSHOT-tests.jar;PocForOneCom-1.0-SNAPSHOT.jar;libs\* -Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome org.testng.TestNG ../TestNG-XML-Suites/Login/LoginTestSuite.xml

java -cp PocForOneCom-1.0-SNAPSHOT-tests.jar;PocForOneCom-1.0-SNAPSHOT.jar;libs\* -Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome org.testng.TestNG ../TestNG-XML-Suites/Smoke/SmokeTestSuite.xml

## Run tests for Mac / Unix environment
mvn clean test -DsuiteXmlFile=TestNG-XML-Suites/Login/LoginTestSuite.xml -Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome

mvn clean test -DsuiteXmlFile=TestNG-XML-Suites/Smoke/SmokeTestSuite.xml -Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome