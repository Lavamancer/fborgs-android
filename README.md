## Coding Test

In the previous test you’ve created an application where the repositories of the Facebook organization were listed.
In this test we will add some complexity to the application.
The job is to be able to click on a repository in the list where all the issues will be listed for the repository. 
More information on listing the issues for a repository can be found here.. As you can see the collection contains pagination, which should be implemented as well. 
You can test this with the facebook/buck repository which currently has ~420 open issues.
After implementing the pagination, the screen should be implemented like this design. We used Marvel to handoff the designs to the developers. 
As you can see, you can see all the dimensions of the design within the tool.
The reason we want this design to be implemented is because at Flex-Appeal we attach great value to the product and the implementation of the design. 

## Acceptance criteria

DONE - The repository can be clicked and will transition to the designed screen, where all the open issues are shown for the repository.
DONE - The list of open issues will be implemented using pagination of 10 items per page. 
DONE - The scroll view should be scrolled smoothly.
The open issues list is implemented via the delivered design.
All the elements in the design should be custom made. A material design library cannot be used.




# Facebook Organizations App

Thank you for taking the time to do our technical test. 
In order to avoid bounced emails we would like you to submit your results by uploading the relevant ZIP file to a shared Google Drive folder.
Please make this a single zip file named {yourname}-{role-applied-for}.zip containing the project.
juan-albarracin-android-developer.zip

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
