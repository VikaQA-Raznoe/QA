Feature: google
Scenario:Finding some cars
    Given I am on the Google search page
    When I search for <search>
    And I click button_enter
    Then The page title contains <expected_word>
Examples:
    |search|expected_word|
    |cars  |cars         |
    |boats |boats        |
    |cat   |cat          |

