package am.itspace.listingapp.repository;

import am.itspace.listingapp.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing,Integer> {


    Listing getByUserEmail(String email);
    List<Listing> getByCategoryId(int id);
    Listing getById(int id);
}
