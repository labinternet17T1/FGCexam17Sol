package cat.tecnocampus;

import cat.tecnocampus.domain.*;
import cat.tecnocampus.repositories.StationRepository;
import cat.tecnocampus.repositories.UserRepository;
import cat.tecnocampus.services.LaPoblaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FcGhackappBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(FcGhackappBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LaPoblaService laPoblaService, StationRepository stationRepository) throws Exception {
		return args -> {
			//adding stations to the database
			List<Station> stations = laPoblaService.getLaPoblaStations();

			if (stations != null) {
				stations.forEach(System.out::println);

				stationRepository.saveStations(stations);
			}
		};
	}

/*
	private void createUser(StationRepository stationRepository, UserRepository userRepository) {
		Journey journey = new Journey();
		journey.setDestination(stationRepository.findOne(new Long(1)));
		journey.setOrigin(stationRepository.findOne(new Long(3)));

		Ride ride1 = new Ride();
		ride1.setBegin(LocalDateTime.now().minusHours(2));
		ride1.setEnd(LocalDateTime.now());
		ride1.setJourney(journey);

		Ride ride2 = new Ride();
		ride2.setBegin(LocalDateTime.now().minusHours(2));
		ride2.setEnd(LocalDateTime.now().minusHours(1));
		ride2.setJourney(journey);

		FavoriteJourney favoriteJourney = new FavoriteJourney();
		favoriteJourney.setJourney(journey);
		ArrayList<DayTimeStart> days = new ArrayList<>();
		DayTimeStart start1 = new DayTimeStart();
		start1.setBegin(LocalTime.now());
		start1.setDayOfWeek(DayOfWeek.FRIDAY);
		DayTimeStart start2 = new DayTimeStart();
		start2.setBegin(LocalTime.now());
		start2.setDayOfWeek(DayOfWeek.MONDAY);
		days.add(start1);
		days.add(start2);
		favoriteJourney.setStartList(days);
		ArrayList<FavoriteJourney> favList =new ArrayList<>();
		favList.add(favoriteJourney);

		User user = new User();
		user.setUsername("roure");
		user.setName("Josep");
		user.setSecondName("Roure");
		user.setThirdName("Alcobé");
		user.setCity("Mataró");
		user.setEmail("roure@hola.cat");
		user.setPassword("hola");
		user.setPostalCode("08302");
		user.setToken("hola");
		ArrayList<Ride> rideList = new ArrayList<>();
		rideList.add(ride1);
		rideList.add(ride2);
		user.setRideList(rideList);

		user.setFavoriteJourneyList(favList);

		userRepository.save(user);
	}

	private void loadUser(UserRepository userRepository) {
		User u = userRepository.findOne("roure");

		System.out.println(u.getUsername());
		System.out.println(u.toString());
	}
*/
}
