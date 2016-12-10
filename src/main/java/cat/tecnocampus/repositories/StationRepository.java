package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.Station;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by roure on 16/11/2016.
 */
@Repository
public class StationRepository  {

    private final JdbcTemplate jdbcTemplate;

    public StationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] saveStations(List<Station> stations) {
        return jdbcTemplate.batchUpdate("INSERT INTO station (longitud, latitud, nom) values(?, ?, ?)",
                new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Station station = stations.get(i);
                preparedStatement.setString(1, station.getLongitud());
                preparedStatement.setString(2, station.getLatitud());
                preparedStatement.setString(3, station.getNom());
            }

            @Override
            public int getBatchSize() {
                return stations.size();
            }
        });
    }

    public List<Station> findAll() {

        return jdbcTemplate.query("SELECT * FROM STATION", new StationMapper());
    }

    public Station findOne(String nom) {
        return jdbcTemplate.queryForObject("select * from station where nom = ?", new StationMapper(), nom);
    }

    public final class StationMapper implements RowMapper<Station> {
        @Override
        public Station mapRow(ResultSet resultSet, int i) throws SQLException {
            Station station = new Station();

            station.setNom(resultSet.getString("nom"));
            station.setLatitud(resultSet.getString("latitud"));
            station.setLongitud(resultSet.getString("longitud"));

            return station;
        }
    }

}
