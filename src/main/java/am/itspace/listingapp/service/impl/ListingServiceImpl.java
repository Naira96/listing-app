package am.itspace.listingapp.service.impl;


import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.Category;
import am.itspace.listingapp.model.Listing;
import am.itspace.listingapp.repository.CategoryRepository;
import am.itspace.listingapp.repository.ListingRepository;
import am.itspace.listingapp.repository.UserRepository;
import am.itspace.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;



    @Override
    public List<Listing> getListings() {
        return listingRepository.findAll();
    }

    @Override
    public Listing getByUserEmail(String email) throws ResourceNotFoundException {
        boolean userFromDB = userRepository.getByEmail(email) == null;
        if (userFromDB) {
            throw new ResourceNotFoundException("Listing does not exist!");
        } else {
            return listingRepository.getByUserEmail(email);
        }
    }

    @Override
    public void addListing(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public List<Listing> getByCategoryId(int id) throws ResourceNotFoundException {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("listing does not exist");
        }
        return listingRepository.getByCategoryId(id);
    }

    @Override
    public void delete(int id) {
        listingRepository.deleteById(id);
    }

    @Override
    public Listing getById(int id) {
        return listingRepository.getById(id);
    }
}
