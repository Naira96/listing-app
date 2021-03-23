package am.itspace.listingapp.controller;

import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.Category;
import am.itspace.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        if (category.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        return categoryService.addCategory(category);
    }

    @PutMapping("{id}")
    public Category update(@RequestBody Category category, @PathVariable("id") int id) throws ResourceNotFoundException {
        Category categoryFromDB = categoryService.getById(id);
        categoryFromDB.setName(category.getName());
        return categoryService.addCategory(categoryFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        categoryService.deleteById(id);
    }

}
