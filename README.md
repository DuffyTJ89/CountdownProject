# Countdown Project

This is a repo for our final year project. The main aim of this project was to showcase skills we have learned over our 4-year course in GMIT. 
The goal was to create a three-tier application which includes a front-end, back-end and database.

We chose countdown because we thought it was a good game to try to implement in a WebApp. The rules are easy to understand from a logic perspective and we were able to change them around a bit to offer a bit more variety in our scoring system. We felt it would be a good demonstration of the skills we have picked up over the last 4 years of college.

The application starts by asking a user to either login or signup with a new account. After either a successful login or signup the user is redirected to a welcome page.

From here the player can start a new game. Each player will play through three rounds trying to pick up as many points as possible by using as many of their randomly generated letters as possible.

Each round will last 30 seconds and the player must enter their answer before the clock hits zero or the round will end and they will get a score of zero.

If they enter the word in the time frame and the word (which we will check using the implemented Oxford online dictionary) is correct they will receive points for each letter based on our letter scoring system. This scoring system can be viewed in the rules page which is available after login or sign up.

Scores are recorded on our database at the end of the third round and the 10 best ones will be displayed in the high scores page.

#### How to install the WebApp and run locally

To use the app locally the following is required to be installed:

| Tech | Link |
| ------ | ------ |
| IntelliJ IDEA| https://www.jetbrains.com/idea/ |
| Apache Tomcat | http://tomcat.apache.org/ |
| MongoDB | https://www.mongodb.com/download-center/community |
| Java JDK 8 | https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html |

Steps to create the application:
1) Open IntelliJ and set up a new maven project
2) In the next window name : 
    a) groupId : ie.gmit.sw
    b) artifactId  : CountdownProject
    c) version : 1.0-SNAPSHOT
3) Next window, specify the save location and click finish button
4) Right click on the created project and select "add framework support" and select Web Application from list
5) Copy all our project files to the appropriate folders in your newly created maven web app template
6) In the project structure create artifact CountdownProject:war exploaded 
7) After this is finished go to edit configurations and add tomcat as your local server
8) With mongoDB installed, create database called user_records
9) Run the application
10) Sign up to create users to log in and play the game

Our Countdown WebApp uses JSP as a front end, Java for the backend which does all the logic of the game and mongoDB as our database. We use TomCat as our server.

The application can be run locally and is also hosted on AWS. We chose Amazon Web Service as our cloud hosting service for our application, because it offers low cost, high levels of reliability and fast performance.
