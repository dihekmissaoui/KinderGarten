package tn.esprit.spring.control;

import tn.esprit.spring.entity.*;

import tn.esprit.spring.service.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private static final String ENTITY_NAME = "category";



    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws URISyntaxException {
        log.debug("REST request to save Category : {}", category);
        if (category.getId() != null) {
            throw new RuntimeException("A new category cannot already have an ID");
        }
        Category result = categoryService.save(category);
        return ResponseEntity.created(new URI("/api/categories/" + result.getId()))
            .body(result);
    }

    
    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws URISyntaxException {
        log.debug("REST request to update Category : {}", category);
        if (category.getId() == null) {
            throw new RuntimeException("Invalid id");
        }
        Category result = categoryService.save(category);
        return ResponseEntity.ok()
            .body(result);
    }

   
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        log.debug("REST request to get all Categories");
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        log.debug("REST request to get Category : {}", id);
        Optional<Category> category = categoryService.findOne(id);
        return ResponseEntity.ok(category.orElse(null));
    }

   
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.debug("REST request to delete Category : {}", id);
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
