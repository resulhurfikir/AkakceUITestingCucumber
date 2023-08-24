Feature: This case was prepared for Akakce

  Background: Use Login Process Firstly
    Given Navigate to Akakce Website
    When Click on the *Giris Yap* button on right up side
    And User enter valid email and password
    When Click on the *Giris Yap* button under the boxes
    Then Verify that the user should be logged successfully

  @Smoke @Regression
  Scenario: User should be able to add product into the watch list
    Given SendKeys to the Element
      | searchBox | iphone |
    And Click on the Element
      | searchIconu |
    And Choose a product from the result list randomly and click on it
    And Click on the *takip butonu* to add the product into the watch list
    And Click on the *Takip Lisesi Iconu* to go to the watch list
    Then Verify that the product that is chosen randomly is in the watch list

  @Smoke @Regression @Parallel
  Scenario: The user should be able to unfollow all items in the watch list
    Given Click on the Element
      | takipListesiIconu |
    And Empty watch list if there are any products on the list
    Then Verify that the watch list is empty