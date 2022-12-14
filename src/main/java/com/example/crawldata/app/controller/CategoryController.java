package com.example.crawldata.app.controller;

import com.example.crawldata.app.response.CategoryResponse;
import com.example.crawldata.app.response.PageResponse;
import com.example.crawldata.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {
  @Autowired private CategoryService categoryService;

  @GetMapping
  public PageResponse<CategoryResponse> getCategories(){
    return PageResponse.createFrom(categoryService.getCategories());
  }

}
