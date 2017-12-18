# Internet Lab: Final Examination
# FGC La Pobla line: Favorite Journeys

The domain of the exercise is the public transportation (Ferrocarrils de la Generalitat de Catalunya) and their users. 
It's aim is to give some complementary services around FGC lines.

## Classes in the domain:
* User
* Station (name and position)
* Journey (consist of two stations: the origin and the destination)
* DayTimeStart (consist of a dayOfWeek and a start time)
* FavoriteJourney (a journey that a user travels frequently and the moment he uses it: consists of a Journey and a list of DayTimeStart)


## Application use cases 
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
