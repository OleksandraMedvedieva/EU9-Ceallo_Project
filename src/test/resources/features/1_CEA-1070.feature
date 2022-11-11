Feature: Default

	Background:
		#@CEA-1070
		Given user is on the Ceallo dashboard page
		
		

	#{color:#00875a}+*User Story :*+{color}
	#
	#{color:#172b4d}As a user, I should be able to change my online status and set a status message{color}
	#
	#+_*{color:#de350b}Acceptance Criteria:{color}*_+
	# # *{color:#172b4d}User can view Online Status{color}*
	@CEA-1071
	Scenario: Verify user can view Online Status
		Scenario: Verify if user can view Online Status
		    When user clicks on the User Icon
		    Then user can see user status
		    When user clicks on user status
		    Then verify if user can view all online statuson the page
		      | Online         |
		      | Away           |
		      | Invisible      |
		      | Do not disturb |