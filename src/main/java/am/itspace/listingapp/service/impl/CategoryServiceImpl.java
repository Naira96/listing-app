package am.itspace.listingapp.service.impl;

import am.itspace.listingapp.model.Category;
import am.itspace.listingapp.repository.CategoryRepository;
import am.itspace.listingapp.service.CategoryService;
import am.itspace.listingapp.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) throws ResourceNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Categories with " + id + "does not exist"));
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

}
