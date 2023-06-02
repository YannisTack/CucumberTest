Feature: Todo CRUD

  Scenario: Creating a todo
    Given the homepage is shown
    And the item called "Automation is fun!" is not yet added
    When I add a new todo item called "Automation is fun!"
    Then the item called "Automation is fun!" is visible

  Scenario: Deleting a todo
    Given the homepage is shown
    And there are no todo items
    When I add the following list of items
    | "A first task" |
    | "DeleteThisItem?" |
    | "A second task" |
    And I delete the todo item called "DeleteThisItem?"
    Then 2 todo items are visible
    And I don't see the item called "DeleteThisItem?"