package cat.tecnocampus.webController;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domainController.FgcController;
import cat.tecnocampus.exception.UserDoesNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

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

    @GetMapping("/user/favoriteJourney")
    public String getAddFavoriteJourney(Principal principal, Model model) {

        model.addAttribute("username", principal.getName());
        model.addAttribute("stationList", fgcController.getStationsFromRepository());
        model.addAttribute("favoriteJourney", new FavoriteJourney());

        return "newFavoriteJourney";
    }

    @PostMapping("/user/favoriteJourney")
    public String postAddFavoriteJourney(Principal principal, @Valid FavoriteJourney favoriteJourney, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "newFavoriteJourney";
        }

        fgcController.addUserFavoriteJourney(principal.getName(), favoriteJourney);
        model.addAttribute("favoriteJourney", favoriteJourney);

        return "redirect:/user/favoriteJourneys";
    }

    @GetMapping("/user/favoriteJourneys")
    public String getFavoriteJourneys(Principal principal, Model model) {
        String username = principal.getName();

        System.out.println("web controller: going to show favorite journeys");

        model.addAttribute("username", username);
        model.addAttribute("favoriteJourneys", fgcController.getFavoriteJourneys(username));
        return "favoriteJourneys";
    }

    @GetMapping("/byebye")
    public String byebye() {

        return "byebye";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", fgcController.getUsers());

        return "users";
    }

    @GetMapping("/users/{username}")
    public String user(@PathVariable String username, Model model) {
        model.addAttribute("tuser", fgcController.getUser(username));

        return "user";
    }

    private void checkUserExists(@PathVariable String username) throws UserDoesNotExistsException{
        if (!fgcController.existsUser(username)) {
            UserDoesNotExistsException e = new UserDoesNotExistsException("Non existing resource");
            e.setUsername(username);
            throw e;
        }
    }
}
