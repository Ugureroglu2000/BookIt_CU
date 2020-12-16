
Feature: HuntMultiple Module
  @hun
  Scenario Outline: Different users can book a room properly
    Given user enters "<Username>", "<Password>" and logged in successfully
    When user choose the date and hours from A to B
    And user chooses a "<room>" and confirms booking
    Then user books a room successfully
    Then cancel booking from my schedule
    Examples:
      |Username|Password|room|
      | userStudent    | passwordStudent    |room1|
      | userStudent    | passwordStudent    |room2|
      | userStudent    | passwordStudent    |room3|
      | userStudent    | passwordStudent    |room4|
      | userTeamLeader | passwordTeamLeader |room1|
      | userTeamLeader | passwordTeamLeader |room2|
      | userTeamLeader | passwordTeamLeader |room3|
      | userTeamLeader | passwordTeamLeader |room4|
      | userTeacher    | passwordTeacher    |room1|
      | userTeacher    | passwordTeacher    |room2|
      | userTeacher    | passwordTeacher    |room3|
      | userTeacher    | passwordTeacher    |room4|
