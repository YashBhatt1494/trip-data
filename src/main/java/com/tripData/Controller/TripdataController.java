package com.tripData.Controller;

import com.tripData.Repository.PlaceRepository;
import com.tripData.entity.Place;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class TripdataController {
    private PlaceRepository placeRepository;

    public TripdataController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping
    public List<Place> getAllPlace() {
        return this.placeRepository.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Place createPlace(@RequestBody Place newPlace) {
        return this.placeRepository.create(newPlace);
    }

    @GetMapping(value = "/{placeId}")
    public Place getPlaceById(@PathVariable Long placeId) {
        return this.placeRepository.find(placeId);
    }

    @PutMapping(value = "/{placeId}")
    @ResponseStatus(HttpStatus.OK)
    public Place updatePlace(@PathVariable Long placeId, @RequestBody Place updated) {
        return this.placeRepository.update(placeId, updated);
    }

    @DeleteMapping(value = "/{placeId}")
    @ResponseStatus(HttpStatus.OK)
    public Place deletePlace(@PathVariable Long placeId) {
        return this.placeRepository.delete(placeId);
    }
}
