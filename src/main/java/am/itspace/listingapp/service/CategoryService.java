package am.itspace.listingapp.service;

import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();

    Category getById(int id) throws ResourceNotFoundException;

    Category addCategory(Category category);

    void deleteById(int id);
}
