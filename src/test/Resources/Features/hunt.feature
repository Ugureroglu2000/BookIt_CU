@hunt
Feature: Hunt Module
  Background:
    Given user enters Username, Password and logged in successfully
#  @wip
#  Scenario:Clean the booking schedule
#    Then cancel booking from my schedule
  @log
    Scenario: user can book a room properly
      When user choose the date and hours from A to B
      And user chooses a room and confirms booking
      Then user books a room successfully
      Then cancel booking from my schedule

  Scenario: user can not book a booked room again
    When user choose the date and hours from A to B
    And user chooses a room and confirms booking
    Then user books a room successfully
    Then user cannot book a booked room
