package cat.tecnocampus.webController;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domainController.FgcController;
import cat.tecnocampus.exception.UserDoesNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getStations(Model model) {

        model.addAttribute("stationList", fgcController.getStationsFromRepository());

        return "stations";
    }

    @GetMapping("/users/{username}/add/favoriteJourney")
    public String getAddFavoriteJourney(@PathVariable String username, Model model) {

        checkUserExists(username);

        model.addAttribute("username", username);
        model.addAttribute("stationList", fgcController.getStationsFromRepository());

        return "newFavoriteJourney";
    }

    @PostMapping("/users/{username}/add/favoriteJourney")
    public String postAddFavoriteJourney(@PathVariable String username, FavoriteJourney favoriteJourney, Model model) {

        checkUserExists(username);

        fgcController.addUserFavoriteJourney(username, favoriteJourney);
        model.addAttribute("favoriteJourney", favoriteJourney);

        return "redirect:/users/{username}/favoriteJourneys";
    }

    @GetMapping("/users/{username}/favoriteJourneys")
    public String getFavoriteJourneys(@PathVariable String username, Model model) {

        checkUserExists(username);

        model.addAttribute("username", username);
        model.addAttribute("favoriteJourneys", fgcController.getFavoriteJourneys(username));
        return "favoriteJourneys";
    }

    @GetMapping("/byebye")
    public String byebye() {

        return "byebye";
    }

    private void checkUserExists(@PathVariable String username) throws UserDoesNotExistsException{
        if (!fgcController.existsUser(username)) {
            UserDoesNotExistsException e = new UserDoesNotExistsException("Non existing resource");
            e.setUsername(username);
            throw e;
        }
    }
}
