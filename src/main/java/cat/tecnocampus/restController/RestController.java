package cat.tecnocampus.restController;

import cat.tecnocampus.domain.Station;
import cat.tecnocampus.domain.User;
import cat.tecnocampus.domainController.FgcController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/")
public class RestController {
    private FgcController fgcController;

    public RestController(FgcController fgcController) {
        this.fgcController = fgcController;
    }

    @RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return fgcController.getUsers();
    }

    @RequestMapping(value="stations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Station> getStation() {
        return fgcController.getStationsFromRepository();
    }
}
