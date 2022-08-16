package com.example.crawldata.domain.service;

import com.example.crawldata.domain.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NewsService extends BaseService {
  public Page<News> findNewsByCategoryId(Integer categoryId, Pageable pageable) {

    return newsStorage.findNewsByCategoryId(categoryId, pageable);
  }

}
