package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.DayTimeStart;
import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domain.Journey;
import cat.tecnocampus.domain.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by roure on 13/12/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteJourneyRepositoryTest {

    @Autowired
    FavoriteJourneyRepository favoriteJourneyRepository;

    @Test
    public void storeFavoriteJourneyDayTime() throws Exception{
        FavoriteJourney favoriteJourney = createFavoriteJourney();
        final String user = "messi";

        int numFavoritesBefore = favoriteJourneyRepository.findFavoriteJourneys(user).size();

        favoriteJourneyRepository.saveFavoriteJourney(favoriteJourney, user);

        int numFavoritesAfter = favoriteJourneyRepository.findFavoriteJourneys(user).size();
        assertEquals("Expected number of favorites", numFavoritesBefore+1, numFavoritesAfter);
    }

    public static FavoriteJourney createFavoriteJourney() {
        FavoriteJourney favoriteJourney = new FavoriteJourney();
        Station origin, destination;
        Journey journey;
        List<DayTimeStart> starts;

        origin = new Station();
        origin.setNom("Lleida-Pirineus");
        destination = new Station();
        destination.setNom("Tremp");

        journey = new Journey(origin, destination);

        starts = IntStream.range(0, 3)
                .mapToObj(i -> {
                    DayTimeStart d = new DayTimeStart("Monday", "" + i); return d;})
                .collect(Collectors.toList());

        favoriteJourney.setJourney(journey);
        favoriteJourney.setStartList(starts);

        return favoriteJourney;
    }
}
