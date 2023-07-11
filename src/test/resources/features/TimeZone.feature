Feature: TimeZone feature

  Scenario: Check match time according timezone
    Given user is on start page
    When user clicks on any not started event
    Then match start day and time are visible
    When user opens site menu
    And user click the 'Settings' button
    And user chooses new time zone
    And user click the 'Apply' button
    Then the start date and time of the event changed accordingly
