Feature:Trello api test with pojo

  Scenario: Create_Board_POJO
    Given POST request for create board "deneme1" with pojo
    And get response with pojo
    And assert response "deneme1"