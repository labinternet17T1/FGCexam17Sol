package cat.tecnocampus.webController;

import cat.tecnocampus.services.LaPoblaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by roure on 14/11/2016.
 */
@Controller
public class WebController {

    private LaPoblaService laPoblaService;

    public WebController(LaPoblaService laPoblaService) {
        this.laPoblaService = laPoblaService;
    }


    @GetMapping("/stations")
    public String getSations(Model model) {

        model.addAttribute("stationList", laPoblaService.getLaPoblaStations());

        return "stations";
    }
}
