package co.edu.poli.productservice.controller;

import co.edu.poli.productservice.helpers.Response;
import co.edu.poli.productservice.helpers.ResponseBuild;
import co.edu.poli.productservice.persistence.entity.Category;
import co.edu.poli.productservice.service.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServices categoryServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@RequestBody Category category){
        categoryServices.save(category);
        return build.success(category);
    }

    @GetMapping
    public Response findAll(){
        return build.success(categoryServices.findAll());
    }

}