package com.tripData.Repository;

import com.tripData.Repository.PlaceRepository;
import com.tripData.entity.Place;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class PlaceRepositoryImp implements PlaceRepository {

    private JdbcTemplate template;

    public PlaceRepositoryImp(DataSource source) {
        this.template = new JdbcTemplate(source);
    }


    @Override
    public List<Place> list() {
        return template.query("SELECT place_id, place_name, state, address FROM places;", mapper);
    }

    @Override
    public Place find(Long placeId) {
        return template.query("SELECT place_id, place_name, state, address FROM places WHERE place_id = ?;",
                new Object[] {placeId},extractor);
    }

    @Override
    public Place create(Place newPlace) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO places (place_name, state, address) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, newPlace.getPlaceName());
            statement.setString(2, newPlace.getState());
            statement.setString(3, newPlace.getAddress());
            return statement;
        }, generatedKeyHolder);

        return find(generatedKeyHolder.getKey().longValue());
    }

    @Override
    public Place delete(Long placeId) {
        Place current = find(placeId);
        template.update("DELETE FROM places WHERE place_id = ?", new Object[] {placeId});
        return current;
    }

    @Override
    public Place update(Long placeId, Place update) {
        template.update("UPDATE places SET address = ?, place_name = ?, state = ? WHERE place_id = ?",
                new Object[] {update.getPlaceName(), update.getState(), update.getAddress(), placeId});
        return find(placeId);
    }

    private final RowMapper<Place> mapper = (rs, rowNum) -> new Place(
            rs.getLong("place_id"),
            rs.getString("place_name"),
            rs.getString("state"),
            rs.getString("address")
    );

    private final ResultSetExtractor<Place> extractor = (rs) -> rs.next() ? mapper.mapRow(rs, 1) : null;

}
