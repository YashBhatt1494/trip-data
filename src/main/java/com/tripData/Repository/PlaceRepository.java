package com.tripData.Repository;


import com.tripData.entity.Place;

import java.util.List;

public interface PlaceRepository {
    public Place create(Place any);

    public Place find(Long placeId);

    public List<Place> list();

    public Place update(Long eq, Place any) ;

    public Place delete(Long placeId) ;

}
