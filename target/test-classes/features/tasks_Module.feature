Feature: Tasks Module Functionality
  User Story :
  As a user, I should be able to create a new task list or a single task and add any task
  to completed and important tasks list.

  Background: For the scenarios in the feature file, user is expected to be on Task module page
    Given user is on the Ceallo dashboard page
    And user click on Tasks module


  Scenario Outline: Verify user can create a new list of task by providing valid task name
  and set it color
    When user click on Add list button
    And user types valid list name "<newListName>"
    And  user click on any color "<colorNumber>" from the color picker
    And user click on Save button
    Then user should see new list "<newListName>" with valid name and color under the all list menu
    Examples: valid list names
      | colorNumber | newListName                                                                                                                                                                                                                                                     |
      | 1           | Love                                                                                                                                                                                                                                                            |
      | 2           | Ne                                                                                                                                                                                                                                                              |
      | 3           | New Task                                                                                                                                                                                                                                                        |
      | 4           | The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |


  Scenario Outline:  Verify user can dismiss creation of a new list by pressing "Cancel" btn
    When user click on Add list button
    And user types valid list name "<newListName>"
    And user click on the Cancel button
    Then user should not see new list "<newListName>" under the all list menu
    Examples: valid list names + colors
      | newListName                                                                                                                                                                                                                                                     |
      | Chuck                                                                                                                                                                                                                                                           |
      | Hi                                                                                                                                                                                                                                                              |
      | New                                                                                                                                                                                                                                                         |
      | Phe quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |

  Scenario Outline: Verify that user can NOT create a new list of tasks with DUPLICATED task name + color
    When user click on Add list button
    Then user types valid list name "<duplicatedListName>"
    And user should see error message: The name "<duplicatedListName>" is already used.
    Examples: duplicated list names
      | duplicatedListName |
      | Love               |
      | Ne                 |
      | New Task           |

Scenario Outline: Verify if user can create a new task from the different tabs (created by users)
  When user clicks on one of tab from the menu "<tabName>"
  And user types valid task name "<newTask>" in the input box and clicks Enter
  Then New task name "<newTask>" appears under the related list.
  Examples: new task names
    | newTask        | tabName  |
    | _***           | Love     |
    | Java questions | Ne    |
    | @gmail.com123  | New Task |


  Scenario Outline: Verify if user can create a new task from All and Current tab
    When user clicks on the Settings
    And user select one of the options "<options>" from a Default List dropdown
    When user clicks on one of tab from the menu "<tabName>"
    And user types valid task name "<newTask>" in the input box and clicks Enter
    Then New task name "<newTask>" appears under the related list.
    Examples: options,new task names
      | newTask | tabName | options  |
      | B       | All     | Love     |
      | PO      | Current | New Task |

  @wip
  Scenario Outline:Verify if user can add any task to the list of Completed tasks
  by clicking on the checkbox near the task name
    When user clicks on the tab "<tabName>" from the menu
    And user clicks on the checkbox near the task name "<newTask>" and see 1 Completed Task link on the screen
    When user clicks on "Completed" tab from the menu
    Then user can see recently selected task "<newTask>" in this list.
    Examples: task names
      | newTask |tabName|
      | B       |Love   |
      | PO      |New Task|


Scenario Outline: Verify if user can add any task to the list of Important tasks by clicking on the
star icon on the right side of task line
When user clicks on one of tab from the menu "<tabName>"
And user clicks on the star icon near the task name"<newTask>" and this icon color is changes
When user clicks on "Important" tab from the menu
Then user can see recently selected task "<newTask>" in this list.

  Examples: task names
    | newTask |tabName|
    | B       |Love   |
    | PO      |New Task|

  @wip
  Scenario: Verify if user can see the number of all uncompleted tasks next to the Current tab
    When user clicks on the Settings
    And user select for each of the option of Smart Collection dropdown value "Visible"
    When user clicks on "Current" tab from the menu
    Then User can see amount of all uncompleted tasks next to the Current tab
#Total amount of all uncompleted tasks next to the
# Current tab equals to sum of all tasks and subsastsk
# from each list from the menu.