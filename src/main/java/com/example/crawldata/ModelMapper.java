package com.example.crawldata;

import com.example.crawldata.app.response.CategoryResponse;
import com.example.crawldata.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  CategoryResponse toCategoryResponse(Category category);
}
