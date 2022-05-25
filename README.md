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

Postman Payload Testing:

1. Create some developers

URL: http://localhost:8080/issuetracker/dev/addDeveloper

REQUEST:
{
"name": "A"
}

RESPONSE:
{
"id": 1, "name": "A"
}

Similarly create two more developers - B & C

2. Fetch created developers

URL: http://localhost:8080/issuetracker/dev/getDevelopersList

RESPONSE:
[
{
"id": 1, "name": "A"},
 {"id": 2,
 "name": "B"}, {"id": 3,
 "name": "C"}
]

3. Create some stories

URL: http://localhost:8080/issuetracker/story/addStory

REQUEST:
{
"title" : "Story 1", "description" : "Story 1", "estPointVal" : 8
}

RESPONSE:
{
"issueId": 1, "title": "Story 1", "description": "Story 1",
 "createDt": "2022-05-25", "devName": null,
 "estPointVal": 8,
 "status": "ESTIMATED"
}

Similarly, create more stories like this. Also, create some without 'estPointVal' and some with status as 'Completed'. I have created 10 stories, 8 with 'estPointVal', 1 with 'COMPLETED' status and 1 without 'estPointVal'.

4. Fetch all stories

URL: http://localhost:8080/issuetracker/story/getStoryList

RESPONSE:
[
{"issueId": 1, "title": "Story 1", "description": "Story 1", "createDt": "2022-05-25", "devName": null, "estPointVal": 8, "status": "ESTIMATED"
}, {"issueId": 2, "title": "Story 2", "description": "Story 2", "createDt": "2022-05-25", "devName": null, 
 "estPointVal": 2, 
 "status": "ESTIMATED"}, {"issueId": 3, "title": "Story 3", "description": "Story 3", "createDt": "2022-05-25", 
 "devName": null, "estPointVal": 8, 
 "status": "ESTIMATED"
}, 
 {"issueId": 4, "title": "Story 4", 
 "description": "Story 4", 
 "createDt": "2022-05-25", "devName": null, "estPointVal": 2, 
 "status": "ESTIMATED"}, {
"issueId": 5, 
 "title": "Story 5", 
 "description": "Story 5", 
 "createDt": "2022-05-25", 
 "devName": null, 
 "estPointVal": 8, 
 "status": "ESTIMATED"}, 
{"issueId": 6, "title": "Story 6", "description": "Story 6", "createDt": "2022-05-25", "devName": null, "estPointVal": 2, "status": "ESTIMATED"
}, 
{"issueId": 7, "title": "Story 7", "description": "Story 7", "createDt": "2022-05-25", "devName": null, "estPointVal": 3, "status": "ESTIMATED"
}, 
{"issueId": 8, "title": "Story 8", "description": "Story 8", "createDt": "2022-05-25", "devName": null, "estPointVal": 5, "status": "ESTIMATED"
}, 
{"issueId": 9, "title": "Story 9", "description": "Story 9", "createDt": "2022-05-25", "devName": null, "estPointVal": 5, "status": "COMPLETED"
}, 
{"issueId": 10, "title": "Story 10", "description": "Story 10", "createDt": "2022-05-25", "devName": null, "estPointVal": null, "status": "NEW"
}
]

5. Create some bugs

URL: http://localhost:8080/issuetracker/bug/addBug

REQUEST:
{
"title" : "Bug 1",
 "description" : "Bug 1", "devName" : "A"
}

RESPONSE:
{
"issueId": 1,
 "title": "Bug 1",
 "description": "Bug 1", "createDt": "2022-05-25",
 "devName": "A",
 "priority": "MINOR", "status": "NEW"
}

Similarly, create some more bugs. Also create bugs with no developer assigned and some with priority as 'CRITICAL'.

6. Fetch all bugs

URL: http://localhost:8080/issuetracker/bug/getBugList

RESPONSE:
[{"issueId": 1, "title": "Bug 1", "description": "Bug 1", "createDt": "2022-05-25", "devName": "A", "priority": "MINOR", "status": "NEW"}, {"issueId": 2, "title": "Bug 2", "description": "Bug 2", "createDt": "2022-05-25", "devName": "B", "priority": "CRITICAL", "status": "NEW"}, {"issueId": 3, "title": "Bug 3", "description": "Bug 3", "createDt": "2022-05-25", "devName": null, "priority": "MINOR", "status": "NEW"}
]

7. Fetch Plan

URL: http://localhost:8080/issuetracker/plan

RESPONSE:
{"devList": [{"id": 1, "name": "A", "pointsPicked": 10}, {"id": 2,  "name": "B", "pointsPicked": 10}, {"id": 3, "name": "C", "pointsPicked": 10}], "plannedStoryList": [{"issueId": 1, "title": "Story 1", "description": "Story 1", "createDt": "2022-05-25", "devName": "A", "estPointVal": 8, "status": "ESTIMATED"}, {"issueId": 2, "title": "Story 2", "description": "Story 2", "createDt": "2022-05-25", "devName": "A", "estPointVal": 2, "status": "ESTIMATED"}, {"issueId": 3, "title": "Story 3", "description": "Story 3", "createDt": "2022-05-25", "devName": "B", "estPointVal": 8, "status": "ESTIMATED"}, {"issueId": 4, "title": "Story 4", "description": "Story 4", "createDt": "2022-05-25", "devName": "B", "estPointVal": 2, "status": "ESTIMATED"}, {"issueId": 5, "title": "Story 5", "description": "Story 5", "createDt": "2022-05-25", "devName": "C", "estPointVal": 8, "status": "ESTIMATED"}, {"issueId": 6, "title": "Story 6", "description": "Story 6", "createDt": "2022-05-25", "devName": "C", "estPointVal": 2, "status": "ESTIMATED"}], "backlogStoryList": [{"issueId": 7, "title": "Story 7", "description": "Story 7", "createDt": "2022-05-25", "devName": null, "estPointVal": 3, "status": "ESTIMATED"}, {"issueId": 8, "title": "Story 8", "description": "Story 8", "createDt": "2022-05-25", "devName": null, "estPointVal": 5, "status": "ESTIMATED"}, {"issueId": 10, "title": "Story 10", "description": "Story 10", "createDt": "2022-05-25", "devName": null, "estPointVal": null, "status": "NEW"}], "completedStoryList": [{"issueId": 9, "title": "Story 9", "description": "Story 9", "createDt": "2022-05-25", "devName": null, "estPointVal": 5, "status": "COMPLETED"}], "bugList": [ {"issueId": 1, "title": "Bug 1", "description": "Bug 1", "createDt": "2022-05-25", "devName": "A", "priority": "MINOR", "status": "NEW"}, {"issueId": 2, "title": "Bug 2", "description": "Bug 2", "createDt": "2022-05-25", "devName": "B", "priority": "CRITICAL", "status": "NEW"}, {"issueId": 3, "title": "Bug 3", "description": "Bug 3", "createDt": "2022-05-25", "devName": null, "priority": "MINOR", "status": "NEW"}]
}

JUnit Test Case covered for All Controllers and Handlers. Result - Tests run: 31, Failures: 0, Errors: 0, Skipped: 0
