package cat.tecnocampus.services;

import cat.tecnocampus.domain.Station;
import cat.tecnocampus.services.HelperJTO;
import cat.tecnocampus.services.LaPoblaService;
import cat.tecnocampus.services.StationsListJTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roure on 30/11/2016.
 */
//Delete it for the exam. It gives too many clues

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPOlaPoblaServiceTest {

    @MockBean
    RestTemplate restTemplateMock;

    @Autowired
    LaPoblaService laPoblaService;

    @Test
    public void serviceTest() {
        Station stationA = new Station();
        stationA.setNom("Tremp");
        Station stationB = new Station();
        stationB.setNom("La Pobla");
        List<Station> stations = new ArrayList<>();
        stations.add(stationA);
        stations.add(stationB);
        StationsListJTO stationsListJTO = new StationsListJTO();
        stationsListJTO.setStations(stations);
        HelperJTO helperJTO = new HelperJTO();
        helperJTO.set_embedded(stationsListJTO);

        when(restTemplateMock.getForObject(any(String.class),eq(HelperJTO.class))).thenReturn(helperJTO);

        List<Station> returnedStations = laPoblaService.getLaPoblaStations();
        assertEquals(returnedStations.size(), 2);
        assertEquals(returnedStations.get(0).getNom(), "Tremp");
        assertEquals(returnedStations.get(1).getNom(), "La Pobla");

        verify(restTemplateMock, times(1)).getForObject(any(String.class),eq(HelperJTO.class));
        verifyNoMoreInteractions(restTemplateMock);
    }
}
