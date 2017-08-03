**IMDB Test**

Test to verify the search functionality of IMDb Top 250 Movies Page and assert that there is at least one result for every sort option

These tests are written using _Selenium 2.53_ and use _maven build tool_.

**Pre-Requisites:**

1. Apache Maven 3.3.3
2. Java 1.8

**To run the tests**

1. Clone the repo
2. Switch to the directory
3. Run the below command
`sh run.sh`

These tests are configured to run on Chrome browser.

Downloading chromedriver and running tests on chrome is advised as the the latest firefox version is not supported by selenium 2.53 and it requires downgrading the browser to version < 47.

**Tasks in run.sh**

1. Downloading the chromedriver for the OS under use
2. Running the maven commands to invoke the tests

**If you wish to run the tests from and IDE like IntelliJ:**
1. Clone the repo
2. Open the project in the IDE
3. Download chromedriver from the below url https://chromedriver.storage.googleapis.com/index.html?path=2.31/
4. Unzip and place it in the following location
`src/main/resources/driver/`
5. Select the test folder and run all tests or individual tests