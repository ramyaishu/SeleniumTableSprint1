Feature: Bear And Cat Table
  Background:
     When the user clock the url

    @color
    Scenario: USer needs to Verify details
      And the user verifies the details in the bears table
      Then the number of rows returned should be 3
      And close the browser
    @weight
    Scenario: Usre needs toVerify only details of cats with Weights
      And the user verifies the details in the cat table
      Then it should return "false"
      And close the browser

      @movie
  Scenario: User needs to Verify only two rows of STAR Table.
    And the user verifies the number of rows in the STAR WARS table
    Then the number of rows should be 2
    And close the browser

        @description
  Scenario: User needs toVerify that the values in the Description
    And the user counts number of characters in the description column
    Then the user should return "true"
    And close the browser

