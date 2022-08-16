package com.example.crawldata.domain.service;

import com.example.crawldata.app.response.CategoryResponse;
import com.example.crawldata.domain.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends BaseService{
  public List<CategoryResponse> getCategories(){
    List<CategoryResponse> categoryResponses = new ArrayList<>();
    List<Category> categoryPage = categoryStorage.findAllOrderByIdDesc();
    if (!categoryPage.isEmpty()) {
      for (Category category : categoryPage){
          CategoryResponse categoryResponse = modelMapper.toCategoryResponse(category);
        categoryResponses.add(categoryResponse);
      }
    }
//    Page<CategoryResponse> categoryResponsePage = new PageImpl<>(categoryResponses);
    return categoryResponses;
  }


}
