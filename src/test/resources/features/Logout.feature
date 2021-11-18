@logout
Feature: Logout functionality

  Background: The users should login
    Given the user is on the login page


  Scenario: Verify log out button inside profile
    When the user logs in using "User10" and "UserUser123"
      Then the user can log out by using log out button inside profile info
      And the user ends up in login page.

  Scenario: Verify log out button inside profile
    When the user logs in using "salesmanager101" and "UserUser123"
    Then the user can log out by using log out button inside profile info
    And the user ends up in login page.

  Scenario: Verify log out button inside profile
    When the user logs in using "storemanager85" and "UserUser123"
    Then the user can log out by using log out button inside profile info
    And the user ends up in login page.

#MORE DYNAMIC WAY
    Scenario Outline: Verify log out button inside profile 2

      When the user logs in using "<userType>" and "<password>"
      Then the user can log out by using log out button inside profile info
      And the user ends up in login page.


      Examples:
        | userType        | password|
        | salesmanager101 | UserUser123|
        | storemanager85  |UserUser123 |
        | user1           |UserUser123 |


  Scenario Outline: Verify clicking the step back button after successfully logged out

    When the user logs in using "<userType>" and "UserUser123"
    Then the user tries to  go to the home page again by clicking the step back button after successfully logged out
    And the user ends up in login page.
    Examples:
      | userType        |
      | salesmanager101 |
      | storemanager85  |
      | user1           |

@tab
    Scenario Outline: Verify  that user  logged out if the user close the open tab
      When the user logs in using "<userType>" and "UserUser123"
      And the user closes the tab
      Then the user is again on the login page
     # And the user should not login the page successfully
      Examples:
        | userType        |
        | salesmanager101 |
        | storemanager85  |
        | user1           |


  Scenario Outline: Verify  that user  logged out if the user is away for 5 minutes
   Given the user logs in using "<userType>" and "UserUser123"
   When the user waits for 5 minutes
    Then the user ends up in login page.


    Examples:
      | userType        |
      | salesmanager101 |
      | storemanager85  |
      | user1           |







