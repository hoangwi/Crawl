package com.example.crawldata;

import com.example.crawldata.app.response.CategoryResponse;
import com.example.crawldata.app.response.NewsResponse;
import com.example.crawldata.domain.entity.Category;
import com.example.crawldata.domain.entity.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  CategoryResponse toCategoryResponse(Category category);

  NewsResponse toNewsResponse(News news);
}
