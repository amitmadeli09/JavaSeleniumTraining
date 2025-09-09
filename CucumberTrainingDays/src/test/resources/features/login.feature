Feature: Login functionality
Scenario:
	: Successful Login
  Given I open the browser and launch the login page
  When I login with username "<username>" and password "<password>"
  Then I should see the home page
   Examples: Successful Login
	|username|password|
	|marvel01@gmail.com|IronMan|
	|marvel01@gmail.com|1234|


