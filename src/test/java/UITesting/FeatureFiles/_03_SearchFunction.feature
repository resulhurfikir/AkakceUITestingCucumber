Feature: Searching Functionality


  @Parallel @Regression
  Scenario: All products name in the result list should contain the searched word after searching
    Given Navigate to Akakce Website
    When Send a word to search box
    And jsClick on the Element to apply filtering options
      | searchIconu  |
      | outdoorGiyim |
    Then Verify that results contain searched word