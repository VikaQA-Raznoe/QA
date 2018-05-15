Feature: google
Scenario:Finding some cars
    Given I am on the Google search page
    When I search for "Cars"
    And I click button_enter
    Then The page title contains "Cars"
