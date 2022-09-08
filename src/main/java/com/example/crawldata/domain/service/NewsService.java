package com.example.crawldata.domain.service;

import com.example.crawldata.app.response.NewsResponse;
import com.example.crawldata.domain.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NewsService extends BaseService {
  public Page<NewsResponse> findNewsByCategoryId(Integer categoryId, Pageable pageable) {
    Page<News> newsPage = newsStorage.findNewsByCategoryId(categoryId, pageable);
    List<NewsResponse> newsResponsesList = new ArrayList<>();
    if(newsPage != null){
      for (News news : newsPage.getContent()){
        NewsResponse newsResponse = modelMapper.toNewsResponse(news);
        newsResponsesList.add(newsResponse);
      }
    }
    return new PageImpl<>(newsResponsesList);
  }

}
