Feature: Test contents of Employee database

  Scenario: Check data in employee table
    Given I have a connection to the 'employees' database
    When I select the columns 'first_name' and 'last_name' from table 'employees'
    Then I get '300024' records

  Scenario: Check datatable in employee table
    Given I have a connection to the 'employees' database
    When I select the following data
      | Fields | Values |
      | emp_no | 11488  |
    Then I get the following data
      | Fields     | Values     |
      | emp_no     | 11488      |
      | first_name | Houman     |
      | last_name  | Veldwijk   |
      | hire_date  | 1987-08-25 |
      | birth_date | 1962-11-18 |
      | gender     | M          |