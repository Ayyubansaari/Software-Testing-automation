**Project Description: Parabank Registration and Login Automation Using Selenium**

**Goal:**
  Automate the process of user registration, logout, and login on the Parabank demo site using Selenium WebDriver (Java).

**Technologies Used:**
  Java

  Selenium WebDriver

  ChromeDriver

  XPath / ID selectors

** Step-by-Step Functional Flow:**
  Launch Chrome browser and open the Parabank site.

  Wait for the page to load using Thread.sleep.

  Click on the "Register" link to open the registration form.

  Locate all form fields (e.g., first name, last name, address, city, state, etc.).

**For each field:**

  Check if it's present and visible using isDisplayed().

  Log success or failure messages.

  Enter user data into all the required registration form fields.

  Submit the registration form by clicking the Register button.

  After a delay, check for the "Log Out" button:

  If available, click it and log out successfully.

  Go back to the login screen:

  Check presence of username and password fields.

  Enter credentials.

  Click "Log In" to test login functionality.

  Done – The script logs actions to the console at every step.

**Key Features:**
  Uses explicit element checking via isDisplayed() for robustness.

  Covers end-to-end registration → logout → login.

  Handles exceptions via try-catch blocks to avoid crashes.

  Fully automated using ChromeDriver.

**Improvements Suggested:**
  Replace Thread.sleep() with WebDriverWait for better synchronization.

  Add assertions to verify successful registration/login (for real test validation).

  Modularize the code (e.g., extract methods for fillRegistrationForm(), loginUser()).

  Use Page Object Model (POM) for scalability and maintainability.

**Sample Console Output:**


successfully enter the firstname.
successfully enter the lastname.
...
successfully registered
Successfully logged out.
successfully enter the username.
successfully enter the password.
