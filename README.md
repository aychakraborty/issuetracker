# Assignment Github Repository Name: issuetracker
# Application Copyright: Chakraborty, Ayan (ayan.avi@gmail.com)
# Assignment Copyright: Pinguin
# Pinguin Assignment - Issue Tracker Application

Application Description:

This is a JVM based backend application build using Springboot REST API. It contains the following end-points:

DEVELOPER:

1. GET /dev/getDevelopersList (get list of developers)
2. POST /dev/addDeveloper (add new developer)
3. PUT /dev/updateDeveloper/{id} (update a developer)
4. DELETE /dev/deleteDeveloper/{id} (delete a developer)
5. DELETE /dev/deleteAllDevelopers (delete all developers)

STORY:

1. GET /story/getStory/{issueId} (get single story)
2. GET /story/getStoryList (get all stories)
3. POST /story/addStory (add new story)
4. PUT /story/updateStory/{issueId} (update a story)
5. DELETE /story/deleteStory/{issueId} (delete a story)
6. DELETE /story/deleteAllStories (delete all stories)

BUG:

1. GET /bug/getBug/{issueId} (get single bug)
2. GET /bug/getBugList (get all bugs)
3. POST /bug/addBug (add new bug)
4. PUT /bug/updateBug/{issueId} (update a bug)
5. DELETE /bug/deleteBug/{issueId} (delete a bug)
6. DELETE /bug/deleteAllBugs (delete all bugs)

PLAN:

1. GET /plan (create the plan and fetch it)

Assignment Short Description:

1. Create CRUD functionality for Developer, Story & Bug
2. Create Plan to assign stories for the week to developers considering each developer can take max 10 story points and complete all stories in minimal weeks.

Framework & Tools Used:

1. Application - Spring framework with Springboot
2. Java - Java v11
3. Database - H2
4. JUnit - JUnit v4
5. Server - Tomcat v9.0

Coding Steps & Functionality:

1. On running the springboot application using Tomcat v9.0 server, use GET, POST, PUT, DELETE endpoints to perform CRUD functionality on developers, stories and bugs.
2. All database configuration present in application.properties file.
3. Using JPA Repository mapping, entity class 'Developer.java', 'Story.java' and 'Bug.java' is configured with respective tables.
4. To create the plan, first filter out the estimated stories and sort them in descending order so that bigger stories can be divided among developers first along with smaller stories to complete all stories in minimum number of weeks.
5. Loop through each developer, finish his/her capacity and move to the next developer. To do so, loop through the stories, check if capacity is reached for a particular developer, if not assign story and move to next story. If capacity is reached for a particular developer, move to the next developer and the process continues untill and unless all the developers are assigned stories or the stories have run out.
5. Publish the plan containing list of developers, list of planned stories, list of backlog stories, list of completed stories and list of bugs.

Application Set-up:

1. Go to Github location: https://github.com/aychakraborty/issuetracker
2. Clone Github repository. (https://github.com/aychakraborty/issuetracker)
3. Open Eclipse IDE. Go to Git Repository view. Clone application using URL and place it in local directory.
4. Go to Java EE view in Eclipse IDE. Right click on Project Explorer -> Import -> Import as Maven Project and give your local repository location where the project has been cloned from Github.
5. Once import is successful, Run Maven build (clean install) on Eclipse IDE. Make note that you have Java v11 configured and the Maven build is running on jdk 1.11.
6. Once Maven build is successful, perform Maven dependency update. (Right click on project -> Maven -> Update project)
7. Install Tomcat v9.0 server and add to Eclipse IDE. Select jdk 1.11 as your environment run.
8. Add issuetracker(issuetracker-0.0.1-SNAPSHOT) to Tomcat server in Eclipse IDE.
9. Double click on Tomcat server. Use port 8080. Increase Timeout to Start 450 s and Stop 150 s.
10. Run Tomcat server with the project. Once server is up, use postman and follow below for postman payload testing.

Database Verification Local URL: http://localhost:8080/issuetracker/h2-console/login.jsp - (credentials present in application.properties)
