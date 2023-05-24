Feature: Todo CRUD

  Scenario: Creating a todo
    Given the homepage is shown
    When I add a new todo item called "Automation is fun!"
    Then the item is visible

  Scenario: Deleting a todo
    Given the homepage is shown
    When I add 3 new todo items
    And I delete 1 of the todo items
    Then I see 2 todo items
    And I don't see the deleted todo item