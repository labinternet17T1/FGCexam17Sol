# Internet Lab: Final Examination
# FGC La Pobla line: Favorite Journeys

The domain of the exercice is the public transportation (Ferrocarrils de la Generalitat de Catalunya) and their users. 
It's aim is to give some complementary services around FGC lines.

## Classes in the domain:
* User
* Station (name and position)
* Journey (consist of two stations: the origin and the destination)
* DayTimeStart (consist of a dayOfWeek and a start time)
* FavoriteJourney (a journey that a user travels frequently and the moment he uses it: consists of a Journey and a list of DayTimeStart)

## Exam completion
In order to fulfill the exam you'll need to go through XXX different TODOs your'll find in the code. See that each TODO 
has an explanation of what you need to do, a list of clues (titled "Note that") and a "POSTCONDITION" section where states 
what test must pass after you completed the code 

Usually each TODO involves very few lines of code

See that in the bottom of the Intellij window there is a tab that list all TODOs (tab 6:TODO)

## Application use cases (not all working)
1. User login (http://localhost/8080/login). It always redirects to /welcome which is inconvenient
1. User logout that redirects to /byebye (http://localhost/8080/logout)
2. List all the stations of La Pobla line (http://localhost:8080/stations)
3. List the favorite journeys from the logged user (http://localhost:8080/user/favoriteJourneys)
4. Add a favorite journey to the logged user (http://localhost:8080/user/favoriteJourney)
1. List all registered users (http://localhost:8080/users)
1. List a given registered user (http://localhost:8080/users{userName})
1. Return a Json with all users without their passwords (http://localhost:8080/api/users)
1. Return a Json with all stations (http://8080/api/stations)

The application has already two users:
* **username**: messi, **password**: messi (with ROLE_USER)
* **username**: ronaldo, **password**: ronaldo (with ROLE_USER and ROLE_ADMIN)

## You'll work on the following
1. Get the stations from an API REST and save to the database
  * TODO 1 : JDBC 
  * TODO 2 : rest client
2. Error handling: when the username doesn't exist
  * TODO 3
3. A get method that returns the form to add a new favorite jouney to a user. The form needs the username and the station list
  * TODO 4
4. The form itself. Work with Thymeleaf
  * TODO 5
5. Security: state the security rules
  * TODO 6
