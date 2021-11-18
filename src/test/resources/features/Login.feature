@login
Feature: Login Functionality
@NV-742
  Scenario: Truck driver can log in with valid credentials

    Given the user is on the login page
    When the user logs in using "user10" and "UserUser123"
    Then the title contains "Quick Launchpad"
  @NV-743
  Scenario: Sales manager can log in with valid credentials

    Given the user is on the login page
    When the user logs in using "salesmanager101" and "UserUser123"
    Then the title contains "Dashboard"
  @NV-744
  Scenario: Store manager can log in with valid credentials

    Given the user is on the login page
    When the user logs in using "storemanager85" and "UserUser123"
    Then the title contains "Dashboard"


  @NV-746
  Scenario Outline: Users can not log in with invalid credentials

    Given the user is on the login page
    When the user logs in using "<userType>" and "UserUser123"
    Then the title contains "Login"
     Examples:
    |userType|
    |storemanager|
    |salesmanager|
    |user        |

  @NV-745
      #MORE DYNAMIC WAY
      Scenario Outline:All users can log in successfully

        Given the user logged in as "<userType>"
        Then the user should see "<page>"
        Examples:
          | userType      | page    |
          | driver        | Quick Launchpad |
          | sales manager | Dashboard       |
          | store manager | Dashboard       |







