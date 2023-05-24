Feature: Todo CRUD

  Scenario: Creating a todo
    Given the homepage is shown
    When I add a new todo item called "Automation is fun!"
    Then the item called "Automation is fun!" is visible

  Scenario: Deleting a todo
    Given the homepage is shown
    And there are no todo items
    When I add a new todo item called "A first task"
    And I add a new todo item called "DeleteThisItem?"
    And I add a new todo item called "A second task"
    And I delete the todo item called "DeleteThisItem?"
    Then 2 todo items are visible
    And I don't see the item called "DeleteThisItem?"