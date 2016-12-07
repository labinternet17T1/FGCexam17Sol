package cat.tecnocampus.domainController;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domain.Station;
import cat.tecnocampus.domain.User;
import cat.tecnocampus.repositories.StationRepository;
import cat.tecnocampus.repositories.UserRepository;
import cat.tecnocampus.services.LaPoblaService;

import java.util.List;

/**
 * Created by roure on 07/12/2016.
 */
public class FgcController {
    private StationRepository stationRepository;
    private UserRepository userRepository;
    private LaPoblaService laPoblaService;

    public FgcController(StationRepository stationRepository, UserRepository userRepository, LaPoblaService laPoblaService) {
        this.stationRepository = stationRepository;
        this.userRepository = userRepository;
        this.laPoblaService = laPoblaService;
    }

    public List<Station> getStationsFromApi () {
        return laPoblaService.getLaPoblaStations();
    }

    public void saveStations(List<Station> stations) {
        stationRepository.saveStations(stations);
    }

    public User getUser(String username) {
        return userRepository.findOneUser(username);
    }

    public boolean existsUser (String username) {
        return userRepository.existsUser(username);
    }

    public void addUserFavoriteJourney(String username, FavoriteJourney favoriteJourney) {

    }
}
