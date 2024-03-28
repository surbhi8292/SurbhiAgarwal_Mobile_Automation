
Feature: Appium Automation
  @Task1
  Scenario Outline: Snapdeal automation task1 [Android]
    Given user launches the snapdeal web application
    And Verify Home Page
    When Enter zipcode "<zipcode>" and verify checkbox
    Then Verify PDP "<mobileno>"
    Examples:
      | zipcode | mobileno  |
      | ZIPCODE | MOBILE_NO |

  @Task2
  Scenario Outline: Snapdeal automation task2 [iOS]
    Given user launches the snapdeal web application
    And Verify Home Page
    When Validate search item "<Search>" after searching for product
    Then Verify Shoe Item
    Then the user should see the pin code "<zipcode>" on the screen
    Then The user should verify the entered pin code
    When The user enters mobile number "<mobileno>" and Click continue

    Examples:
      |  Search     |  | zipcode  |  mobileno  |
      | SEARCH_ITEM |  | ZIPCODE  |  MOBILE_NO |





