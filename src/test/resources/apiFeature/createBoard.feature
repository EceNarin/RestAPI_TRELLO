Feature: Trello_testi

  Scenario: Create_board
    Given Send POST request for create "Testinium" board
    Then  Assert status code 200
    And Assert board name is "Testinium"
