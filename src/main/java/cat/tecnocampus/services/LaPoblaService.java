package cat.tecnocampus.services;

import cat.tecnocampus.domain.Station;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by roure on 16/11/2016.
 */
@Service
public class LaPoblaService {

    private static final String URL = "http://fcghackappbackend-env.eu-central-1.elasticbeanstalk.com/stations";
    private final RestTemplate restTemplate;

    public LaPoblaService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Station> getLaPoblaStations() {
        HelperJTO stations = restTemplate.getForObject(URL, HelperJTO.class);

        return stations.getStations();
    }
}
