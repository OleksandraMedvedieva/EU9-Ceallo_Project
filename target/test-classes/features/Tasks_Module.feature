Feature: Tasks Module Functionality
  User Story :
  As a user, I should be able to create a new task list or a single task and add any task
  to completed and important tasks list.

  Acceptance Criteria:

  User can create a new list of tasks**
  User can create a new task
  User can add any task to the list of completed tasks by clicking on the checkbox near the task name
  User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
  User can see the number of all uncompleted tasks next to the Current tab

  Background: For the scenarios in the feature file, user is expected to be on Task module page
    Given user is on the Ceallo dashboard page
    And user click on Tasks module

  @CEA-988
    @Order(1)
  Scenario Outline: Verify user can create a new list of task by providing valid task name
  and set it color
    When user click on Add list button
    And user types valid list name "<newListName>"
    And  user click on any color "<colorNumber>" from the color picker
    And user click on Save button
    Then verify user see new list "<newListName>" under the list menu
    Examples: valid list names + color
      | colorNumber | newListName                                                                                                                                                                                                                                                     |
      | 1           | 9                                                                                                                                                                                                                                                               |
      | 2           | Ne                                                                                                                                                                                                                                                              |
      | 3           | New Task                                                                                                                                                                                                                                                        |
      | 4           | The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |

  @CEA-990
    @Order(2)
  Scenario Outline: Verify user can dismiss creation of a new list by pressing "Cancel" btn
    When user click on Add list button
    And user types valid list name "<newListName>"
    And user click on the Cancel button
    Then verify user should NOT see new list "<newListName>" under the list menu
    Examples: valid list names
      | newListName                                                                                                                                                                                                                                                     |
      | C                                                                                                                                                                                                                                                               |
      | Hi                                                                                                                                                                                                                                                              |
      | My Tasks                                                                                                                                                                                                                                                        |
      | LOS quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |

  @CEA-991
    @Order(3)
  Scenario Outline: Verify that user can NOT create a new list of tasks by providing DUPLICATED list name
    When user click on Add list button
    Then user types valid list name "<duplicatedListName>"
    And verify user see error message: The name "<duplicatedListName>" is already used.
    Examples: duplicated list names
      | duplicatedListName                                                                                                                                                                                                                                              |
      | 9                                                                                                                                                                                                                                                               |
      | Ne                                                                                                                                                                                                                                                              |
      | New Task                                                                                                                                                                                                                                                        |
      | The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt |

  @CEA-992
    @Order(4)
  Scenario Outline: Verify if user can create a new task from the different tabs (tabs that created by the user manually)
    When user clicks on one of tab from the menu "<tabName>"
    And user types valid task name "<newTask>" in the input box and clicks Enter
    Then verify new task name "<newTask>" appears under the related list.
    Examples:
      | tabName  | newTask        |
      | 9        | *              |
      | Ne       | Java questions |
      | New Task | @gmail.$$@@123 |

  @CEA-993
    @Order(5)
  Scenario Outline: Verify if user can create a new task from All and Current tabs (app default tabs)
    When user clicks on the Settings
    And user select one of the options "<options>" from a Default List dropdown
    When user clicks on one of tab from the menu "<tabName>"
    And user types valid task name "<newTask>" in the input box and clicks Enter
    Then verify new task name "<newTask>" appears under the related list.
    Examples: options,new task names
      | newTask       | tabName | options |
      | *             | All     | 9       |
      | New task name | Current | Ne      |

  @CEA-994
    @Order(6)
  Scenario Outline: Verify if user can add any task to the list of Completed tasks by clicking on the checkbox near the task name
    When user clicks on one of tab from the menu "<tabName>"
    And user clicks on the checkbox near the task name "<newTask>" and see 1 Completed Task link on the screen
    When user clicks on one of tab from the menu "Completed"
    Then verify user can see recently selected task "<newTask>" in this list.
    Examples: task names
      | newTask       | tabName |
      | *             | 9       |
      | New task name | Ne      |

  @CEA-995
    @Order(7)
  Scenario Outline: Verify if user can add any task to the list of Important tasks by clicking on the star icon on the right side of task line
    When user clicks on one of tab from the menu "<tabName>"
    And user clicks on the star icon near the task name"<newTask>" and this icon color is changes
    When user clicks on one of tab from the menu "Important"
    Then verify user can see recently selected task "<newTask>" in this list.
    Examples: task names
      | newTask        | tabName |
      | *              | 9       |
      | Java questions | Ne      |

  @CEA-996
  @Order(8)
  Scenario: Verify if user can see the number of all uncompleted tasks next to the Current tab
    When user clicks on the Settings
    And user select for each of the option of Smart Collection dropdown value "Visible"
    When user clicks on one of tab from the menu "Current"
    Then verify ser can see amount of all uncompleted tasks next to the Current tab
#Total amount of all uncompleted tasks next to the
# Current tab equals to sum of all tasks and subsastsk
# from each list from the menu.