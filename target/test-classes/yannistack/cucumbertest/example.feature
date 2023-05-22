Feature: Todo CRUD

  Scenario: Creating a todo
    Given the homepage is shown
    When I enter a new todo item
    Then the item is visible

  Scenario: Deleting a todo
    Given the homepage is shown
    When I enter 3 new todo items
    And I delete 1 of the todo items
    Then I see 2 todo items
    And I don't see the deleted todo item