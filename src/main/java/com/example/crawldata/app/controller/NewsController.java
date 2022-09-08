package com.example.crawldata.app.controller;

import com.example.crawldata.app.response.NewsResponse;
import com.example.crawldata.app.response.PageResponse;
import com.example.crawldata.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class NewsController {
  private @Autowired NewsService newsService;

  @GetMapping("categories/{categoryId}/news")
  public PageResponse<NewsResponse> getCategories(@PathVariable Integer categoryId, Pageable pageable){
    return PageResponse.createFrom(newsService.findNewsByCategoryId(categoryId, pageable));
  }
}
