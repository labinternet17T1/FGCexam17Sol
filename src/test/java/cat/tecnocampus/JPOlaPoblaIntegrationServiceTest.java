package cat.tecnocampus;

import cat.tecnocampus.domain.Station;
import cat.tecnocampus.services.LaPoblaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by roure on 30/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPOlaPoblaIntegrationServiceTest {
    @Autowired
    LaPoblaService laPoblaService;

    @Test
    public void serviceIntegrationTest() {
        List<Station> returnedStations = laPoblaService.getLaPoblaStations();
        assertEquals(returnedStations.size(), 16);
        assertEquals(returnedStations.get(0).getNom(), "Alcoletge");
        assertEquals(returnedStations.get(1).getNom(), "Vilanova de la Barca");

    }

}
