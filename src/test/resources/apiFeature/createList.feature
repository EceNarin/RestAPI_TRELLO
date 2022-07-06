Feature: Trello_testi

  Scenario: Create_list
    Given Send POST request for create "First List" list
    Then  Assert status code is 200
    And Assert list name is "First List"
