# Android Recruitment Test Flex-Appeal

Thank you for taking the time to do our technical test. 
In order to avoid bounced emails we would like you to submit your results by uploading the relevant ZIP file to a shared Google Drive folder.
Please make this a single zip file named {yourname}-{role-applied-for}.zip containing the project.
juanalbarracin-androiddeveloper.zip

## Coding Test

Github has a public API available that can be used to get repository information including its contributors and issues. 
The documentation of the endpoints can be found at https://developer.github.com/v3.

As an example, https://api.github.com/orgs/facebook/repos returns a list of public repositories of the Facebook organization.
The task is to create an application that lists all Facebook’s public repositories where you can search through. 
When clicked on an repository, you will be transitioned to a detail page containing information about the repository, 
such as its contributors, open issues and basic repository information.


## Task Requirements

Feel free to spend as much or as little time on the exercise as you like as long as the following requirements have been met.
Please complete all of the user stories below.
Your code should compile and run in one step.
Feel free to use whatever frameworks/libraries/packages you like.
You must include some unit tests (UI tests are bonus)
Please avoid including artifacts from your local build (such as NuGet packages or the bin folder(s)) in your final ZIP file


## User stories

As a user running the application
I can view a list of public repositories from the Facebook organization
So that I know which repositories are currently available

As a user running the application
I can search through the repositories using a standard text input
So that I can specifically look for a repository

As a user running the application
I can tap on a repository to view repository information
So that I know more information about the repository


## Acceptance criteria

The name, description and tags are displayed of the repository are displayed
The detail page of the repository should contain a tab bar to view a list of contributors and issues
The list views should implement pagination with 20 items per page
