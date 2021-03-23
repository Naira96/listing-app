package am.itspace.listingapp.service;


import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.Listing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ListingService {


    List<Listing> getListings();

    Listing getByUserEmail(String email) throws ResourceNotFoundException;

    List<Listing> getByCategoryId(int id) throws ResourceNotFoundException;

    void addListing(Listing listing);

    Listing getById(int id);

    void delete(int id);
}
