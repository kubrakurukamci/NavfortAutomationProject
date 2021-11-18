@login2
Feature:Login functionality
  @NV-747
  Background:
    Given the user is on the login page
  @NV-748
  Scenario: Truck driver can see the username in profile menu
    When the user logs in using following credentials
      | username  | user10      |
      | password  | UserUser123 |
    Then the user should see the name
  @NV-749
  Scenario: sales manager can see the username in profile menu
    When the user logs in using following credentials
      | username  | salesmanager101     |
      | password  | UserUser123 |
    Then the user should see the name
  @NV-750
  Scenario: store manager can see the username in profile menu
    When the user logs in using following credentials
      | username  | storemanager85    |
      | password  | UserUser123 |
    Then the user should see the name

  @NV-751
  Scenario:  Error message should be displayed for invalid credentials
    When the user logs in using "storemanager" and "UserUser123"
    Then the user should see the error message "Invalid user name or password."

  @NV-753
  Scenario: ‘Forgot Password’ page
    When the user clicks on "Forgot your password?" link
    When the title contains "Forgot Password"

  @NV-754
  Scenario:"Remember me on this computer" link
    And  the user should see the link "Remember me on this computer"
    And the link should be clickable

  @NV-755
  Scenario:Verify that user can use  enter button on keyboard
    And user can use enter key from their keyboard on the login page

  @NV-752
    Scenario: Bullet sign on password box
      And the user should see the password as a bullet sign



