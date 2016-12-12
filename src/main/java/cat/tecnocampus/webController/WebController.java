package cat.tecnocampus.webController;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domain.User;
import cat.tecnocampus.domainController.FgcController;
import cat.tecnocampus.exception.UserDoesNotExistsException;
import cat.tecnocampus.repositories.StationRepository;
import cat.tecnocampus.repositories.UserRepository;
import cat.tecnocampus.services.LaPoblaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by roure on 14/11/2016.
 */
@Controller
public class WebController {

    private FgcController fgcController;

    public WebController(FgcController fgcController) {
        this.fgcController = fgcController;
    }

    @GetMapping("/stations")
    public String getSations(Model model) {

        model.addAttribute("stationList", fgcController.getStationsFromApi());

        return "stations";
    }

    @GetMapping("/users/{username}/add/favoriteJourney")
    public String getAddFavoriteJourney(@PathVariable String username, Model model) {

        if (!fgcController.existsUser(username)) {
            UserDoesNotExistsException e = new UserDoesNotExistsException("Non existing resource");
            e.setUsername(username);
            throw e;
        }

        model.addAttribute("username", username);
        model.addAttribute("stationList", fgcController.getStationsFromRepository());

        return "newFavoriteJourney";
    }

    @PostMapping("/users/{username}/add/favoriteJourney")
    public String postAddFavoriteJourney(@PathVariable String username, FavoriteJourney favoriteJourney, Model model) {

        fgcController.addUserFavoriteJourney(username, favoriteJourney);
        model.addAttribute("favoriteJourney", favoriteJourney);

        return "redirect:/users/{username}/favoriteJourneys";
    }

    @GetMapping("/users/{username}/favoriteJourneys")
    public String getFavoriteJourneys(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("favoriteJourneys", fgcController.getFavoriteJourneys(username));
        return "favoriteJourneys";
    }
}
