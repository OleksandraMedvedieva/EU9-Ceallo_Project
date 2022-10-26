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

  @wip
  Scenario Outline:  Verify user can dismiss creation of a new list by pressing "Cancel" btn
    When user click on Add list button
    And user types valid list name "<newListName>"
    And user click on the Cancel button
    Then user should not see new list "<newListName>" under the all list menu
    Examples: valid list names
      | newListName                                                                                                                                                                                                                                                     |
      | Chuck                                                                                                                                                                                                                                                           |
      | Hi                                                                                                                                                                                                                                                              |
      | New Task                                                                                                                                                                                                                                                        |
      | The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |

#  Scenario: Verify that user can NOT create a new list of tasks with DUPLICATED task name + color
#    When user click on Add list button
#    Then user types duplicated list name
#    And  user click on duplicated color from the "color picker"
#    And user click on Save button
#    Then User should see error message: The name "provided list name" is already used.
#
#  Scenario Outline: Verify if user can create a new task from the different tabs
#    Then user clicks on the Settings
#    And user clicks on the Default list dropdown.
#    Then user clicks on one of the options "<options>" of a dropdown
#    When user clicks on tab "<tabName>"
#    Then Input box should contain the name of the default selected dropdown in the double quotes: Add a current task to "Name"...
#    When user types valid task name "<newTask>" in the input box and press Enter
#    Then New task appears under related list.
#    Examples: options,new task names
#      | options  | newTask        |tabName|
#      | List     | _***           |Current|
#      | New      | Java questions |All|
#      | New Task | @gmail.com123  |New Task|
#      | New List | 1              |List|
#
#  #Scenario: Verify if user can create a new task from All tab
#  #Scenario:  Verify if user can create a new task from any lists (that created by users)
#
#  Scenario:Verify if user can add any task to the list of Completed tasks
#  by clicking on the checkbox near the task name
#    And user clicks on tab "<tabName>"
#    Then user clicks on the checkbox near the "<newTask>"
#    Then 1 Completed Task link appears on the screen.
#  And Total amount of the tasks from the "related list*"/All tab and Current tab (on the menu bar) decreased by 1.
#  And Total amount of the tasks from the Completed tab (on the menu bar) increased by 1.
#
#
#  Scenario: Verify if user can add any task to the list of Important tasks by clicking on the
#  star icon on the right side of task line
#    And user clicks on tab "<tabName>"
#    Then user clicks on the star icon near the "<newTask>"
#    When user clicks on Important tab from the menu.
#    Then User can see recently selected task "<newTask>" in this list.
#
#  Scenario: Verify if user can see the number of all uncompleted tasks next to the Current tab
#    And user clicks on tab "<tabName>"
#    When user types valid task name "<newTask>" in the input box and press Enter
#    Then New task appears under related list.
#    And Total amount of all uncompleted tasks next to the Current tab increase by 1.
#    And Total amount of all uncompleted tasks next to the Current tab equals to sum of all tasks and subsastsk from each list from the menu.