Feature: Amazon Website LogIn

Scenario Outline: Home page LogIn
Given Initialize the browser with chrome
When User navigate to "https://www.amazon.com/" site
And Click on SignIn button
And user enters <Username> and <Password> and Log In
Then Verify, user is successfully Logged In
And Close all browsers

Examples:
|Username	            |Password	|
|tsite3031@gmail.com	|test3031	|
|test99@gmail.com		|test99		|