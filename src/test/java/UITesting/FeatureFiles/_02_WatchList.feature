Feature: Watch List Functionality

  Background: Use Login Process Firstly
    Given Navigate to Akakce Website
    When Click on the *Giris Yap* button on right up side
    Given User enter valid email and password
    When Click on the *Giris Yap* button under the boxes
    Then Verify that the user should be logged successfully


  @Regression
  Scenario: The user should be able to add a product into the watch list by using categories and filters
    Given Hover to Kategoriler and Elektronik orderly then click on the laptop ve notebook link
    And Click on the Element
      | markaHp |
    And jsClick on the Element to apply filtering options
      | ekranKartiRTX4060 |
      | islemciI7         |
    And Click on the Element
      | siralaEnYuksekFiyat |
    And Click on the *takip butonu* to add the product into the watch list
    And Get the product name for verifying
    And Click on the *Takip Lisesi Iconu* to go to the watch list
    Then Verify that the product is in the watch list



