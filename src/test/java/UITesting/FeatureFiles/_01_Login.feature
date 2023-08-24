Feature: Login Functionality with invalid and valid data

  Background:
    Given Navigate to Akakce Website
    When Click on the *Giris Yap* button on right up side


  @Smoke @Regression
  Scenario Outline: The user should not be able to login with invalid multiple data
    Given User enter email as "<email>"  password  as "<password>"
    When Click on the *Giris Yap* button under the boxes
    Then Verify that the user should not be logged successfully

    Examples:
      | email                 | password   |
      | email@email.com       | Deneme123. |
      | rresullress@gmail.com | Yanlis123. |


  @Smoke @Regression
  Scenario: The user should be able to login with valid data
    Given User enter valid email and password
    When Click on the *Giris Yap* button under the boxes
    Then Verify that the user should be logged successfully


