package com.example.crawldata.app.controller;

import com.example.crawldata.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/news")
public class NewsController {
  private @Autowired NewsService newsService;

  @GetMapping("/{categoryId}")
  public ResponseEntity<?> getCategories(@PathVariable Integer categoryId, Pageable pageable){
    return ResponseEntity.ok(newsService.findNewsByCategoryId(categoryId, pageable));
  }
}
