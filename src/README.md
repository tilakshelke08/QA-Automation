# QA Automation 

This project contains automated test cases .

# Project Structure
qa-automation/
├── pom.xml (If using Maven)
├── src
│ ├── main
│ │ └── java
│ │ └── com
│ │ └── example
│ │ └── qa
│ │ └── components
│ │ ├── Components_Apple.java
│ │ └── Components_Amazon.java
│ └── test
│ └── java
│ └── com
│ └── example
│ └── qa
│ └── testcases
│ ├── TestCase1SearchVerification.java
│ ├── TestCase2CartValidation.java
│ └── TestCase3FormValidation.java
├── screenshots/
│ ├── test_case_1/
│ ├── test_case_2/
│ └── test_case_3/
├── reports/ (Optional: if you generate HTML/XML 
reports)
├── testResults.txt (or .csv) (Summary of pass/fail)
└── README.md (Setup & run instructions)


# Tools 

- Java 17+ (JDK 17)
- Maven (for dependency management)
- Selenium WebDriver
- ChromeDriver
- IDE: IntelliJ

## Test Scenarios 

# Test Case 1: Search Product Details on Amazon
- Go to [amazon.in](https://www.amazon.in)
- Search for `Laptop`
- Click top 3 products and capture product detail screenshots
-  ✅ Passed

# Test Case 2: Cart (Amazon)
- Search for `Headphones`
- Add the first result to cart
- Navigate to cart, then remove the item
- ❌ Failed 

# Test Case 3: Apple Account Form 
- Go to [Apple ID signup](https://appleid.apple.com/account)
- Submit the form with empty and invalid values
- Verify error messages
-✅ Passed

# Screenshots

Screenshots  attached for each validation 


