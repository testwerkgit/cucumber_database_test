Feature: Test contents of Employee database

  Scenario: Check data in employee table
    Given I have a connection to the 'employee' database
    When I select the columns 'firstname' and 'lastname' from table 'employees'
    Then I get '25' records

  Scenario: Check datatable in employee table
    Given I have a connection to the 'employee' database
    When I select the following data
      | Fields    | Values              |
      | firstname | Tom                 |
      | lastname  | Kenny               |
    Then I get the following data
      | Fields    | Values              |
      | firstname | Tom                 |
      | lastname  | Kenny               |
      | email     | someone@someone.com |
      | birthdate | 01                  |