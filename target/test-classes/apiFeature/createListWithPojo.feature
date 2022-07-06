Feature:Trello api test with pojo

  Scenario: Create_List_Pojo
    Given POST request for create list "deneme3" with pojo
    Then get list response with pojo
    And assert list response "deneme3"