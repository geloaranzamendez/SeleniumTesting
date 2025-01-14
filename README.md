**For Automation Activity

Project Structure**

**src/test/java/TestNG/AmaysimQA:** Contains the Java source code for test automation.


***************Execution******************

Clone Git project

git clone https://github.com/geloaranzamendez/SeleniumTesting

Run the script

mvn test -Dtest=<TestScript>

Note: You should be at the root directory to run this command. Make sure to replace <TestScript> with the name of the automation script you want to run, for this one, I used SeleniumDEMO as the name of the automation script.

Test Reports
Reports: After test execution, Reports are generated and stored in the allure-results directory. To generate this report temporarily, run this code below.


allure serve ./allure-results


Note: You should be at the allure-results directory to run this command.

Dependencies

Ensure you have the following dependencies installed:

Java 22 or latest
Maven
NodeJs
Chrome Web Driver
Note: Update Chrome webdriver path in test script.

/P1357601/*/*/chromedriver-mac-x64/chromedriver



