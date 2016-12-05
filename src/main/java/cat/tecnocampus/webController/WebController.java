package cat.tecnocampus.webController;

import cat.tecnocampus.repositories.StationRepository;
import cat.tecnocampus.services.LaPoblaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by roure on 14/11/2016.
 */
@Controller
public class WebController {

    private LaPoblaService laPoblaService;
    private StationRepository stationRepository;

    public WebController(LaPoblaService laPoblaService, StationRepository stationRepository) {
        this.laPoblaService = laPoblaService;
        this.stationRepository = stationRepository;
    }

    @GetMapping("/stations")
    public String getSations(Model model) {

        model.addAttribute("stationList", laPoblaService.getLaPoblaStations());

        return "stations";
    }

    @GetMapping("/users/{username}/add/favoriteJourney")
    public String getAddFavoriteJourney(@PathVariable String username, Model model) {

        model.addAttribute("username", username);
        model.addAttribute("stationList", stationRepository.findAll());

        return "newFavoriteJourney";
    }
}
