Feature: Address Functionality

  Background: Use Login Process Firstly
    Given Navigate to Akakce Website
    When Click on the *Giris Yap* button on right up side
    Given User enter valid email and password
    When Click on the *Giris Yap* button under the boxes
    Then Verify that the user should be logged successfully

  @Regression
  Scenario: The user should be able to add a new address
    Given Click on the Element
      | girisDogrulama |
      | adreslerim     |
      | yeniAdresEkle  |
    And Enter the *adres basligi* by using *FakerClass*
    And Choose the *il* and *ilce*
    And Enter the address details by using database with "select * from address"
    And SendKeys to the Element
      | cepTel | 5325323232 |
    And Click on the Element
      | kaydetButonu |
    Then Verify that the address was saved successfully
