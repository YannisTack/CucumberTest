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

  Scenario: Completing a todo
    Given the homepage is shown
    When I add the following list of items
    | "Work on assignments" |
    | "Do the dishes" |
    | "Complete this task" |
    And I complete the task called "Complete this task"
    Then The task called "Complete this task" is completed
    And The number of completed todo items is 1

  Scenario: Editing a todo
    Given the homepage is shown
    And there are no todo items
    When I add the following list of items
    | "Work on assignments" |
    | "Do the dishes" |
    | "Complete this task" |
    And I edit the 2nd todo item to "Edited task"
    Then the text of the 2nd todo item is "Edited task"

  Scenario: Viewing completed todo's
    Given the homepage is shown
    And I added the following list of items
    | "Work on assignments" |
    | "Do the dishes" |
    | "Complete this task" |
    When I set view to completed
    Then 0 items are visible
    And site shows "3 items left"
    When I set view to all
    And I complete following todo items
    | "Work on assignments" |
    | "Complete this task" |
    And I set view to completed
    Then I see following todo items
    | "Work on assignments" |
    | "Complete this task" |
    And site shows "1 item left"