@log
  Feature: Login functionality
    Background:
    Given user is in loginPage
#master git
      Scenario: With valid Username and Password
        When User enters Username and Password
        Then User can Login successfully
      @wip
      Scenario Outline:  with valid username and password
          When users enters "<user>" and "<password>"
          Then User can Login successfully
          Examples:
            | user           | password           |
            | userStudent    | passwordStudent    |
            | userTeamLeader | passwordTeamLeader |
            | userTeacher    | passwordTeacher    |

      Scenario Outline: With Invalid Username and Password
        When User enters "<Username>" and "<Password>"
        Then User can not Login
      Examples:
        | Username              | Password   |
        | wfarrell8n@usnews.com |            |
        |                       | doniafisby |
        | wfarrell8n@usnews.com | doniafisbv |
        | wfarrell8n@usnewv.com | doniafisby |
        |                       |            |
        | Wfarrell8n@usnews.com | doniafisby |
        | wfarrell8n@usnews.com | Doniafisby |