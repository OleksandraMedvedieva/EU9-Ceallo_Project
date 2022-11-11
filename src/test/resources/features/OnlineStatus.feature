Feature: Online Status Functionality
  User Story :

  As a user, I should be able to change my online status and set a status message

  Acceptance Criteria:

  User can view Online Status
  User can change Online Status
  User can set a status message from any default options
  User can set a custom status message with also using any emoji option provided
  User can clear status message or set a time to clear the message automatically

  Background: For the scenarios in the feature file, user is expected to be on dashboard page
    #@CEA-1070
    Given user is on the Ceallo dashboard page

	#{color:#00875a}+*User Story :*+{color}
	#
	#{color:#172b4d}As a user, I should be able to change my online status and set a status message{color}
	#
	#+_*{color:#de350b}Acceptance Criteria:{color}*_+
	# # *{color:#172b4d}User can view Online Status{color}*
  @CEA-1071
  Scenario: Verify if user can view Online Status
    When user clicks on the User Icon
    And user clicks on user status
    Then verify if user can view all online status on the page
      | Online         |
      | Away           |
      | Invisible      |
      | Do not disturb |

#  Scenario Outline: Verify if user can change Online Status
#    When user clicks on the User Icon
#    And user clicks on user status
#    And user clicks on one from the online status "<onlineStatus>"
#    And user clicks on close window button
#    And user clicks on the User Icon
#    Then verify user can see valid user status "<onlineStatus>"
#    Examples:
#      | onlineStatus   |
#      | Online         |
#      | Away           |
#      | Invisible      |
#      | Do not disturb |
#
#  Scenario Outline: Verify if user can set a status message from any default options
#    When user clicks on the User Icon
#    And user clicks on user status
#    And user chose a status message from any default options <defaultStatusMessage>
#    And user clicks on Set Status Message button
#    And user clicks on the User Icon
#    Then verify user can see valid user status <defaultStatusMessage>
#
#    Examples:
#      | defaultStatusMessage |
#      | In a meeting         |
#      | Commuting            |
#      | Working remotely     |
#      | Out sick             |
#      | Vacationing          |
#
#  Scenario: Verify if user can set a custom status message with also using any emoji option provided
#    When user clicks on the User Icon
#    And user clicks on user status
#    When user clicks on online status message input box
#    And user types a custom status message "custom status"
#    And user clicks on emoji option menu and choose one emoji
#    And user clicks on Set StatusMessage button
#    And user clicks on the User Icon
#    Then verify user can see valid user status "custom status"
#
#
#  Scenario Outline: Verify if user can clear status message
#    When user clicks on the User Icon
#    And user clicks on user status
#    And user chose a status message from any default options <defaultStatusMessage>
#    And user clicks on Clear status message button
#    And user clicks on the User Icon
#    Then verify user can see default status??
#
#    Examples:
#      | defaultStatusMessage |
#      | In a meeting         |
#      | Commuting            |
#      | Working remotely     |
#      | Out sick             |
#      | Vacationing          |
#
#  Scenario Outline: Verify if user can set a time to clear the message automatically
#    When user clicks on the User Icon
#    And user clicks on user status
#    And user chose a status message from any default options <defaultStatusMessage>
#    And user clicks on Clear status after dropdown and choose onr option "<clearStatusAfterOptions>"
#    And user clicks on the User Icon
#    Then verify user can see valid option on Clear status after dropdown
#
#    Examples:
#    |clearStatusAfterOptions|


