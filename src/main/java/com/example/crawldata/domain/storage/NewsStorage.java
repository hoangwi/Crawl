package com.example.crawldata.domain.storage;

import com.example.crawldata.domain.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsStorage extends BaseStorage{
  public void save(News news){
    newsRepository.save(news);
  }

  public void saveAll(List<News> newsList){
    newsRepository.saveAll(newsList);
  }

  public News findNewsByCategoryIdAndTitleAndLink(Integer categoryId, String title, String link){
    return newsRepository.findNewsByCategoryIdAndTitleAndLink(categoryId, title, link);
  }

  public Page<News> findNewsByCategoryId(Integer categoryId, Pageable pageable){
    return newsRepository.findNewsByCategoryId(categoryId, pageable);
  }

  public List<News> findByCategoryIdAndUpdateAtLessThan(Integer categoryId, Long time){
    return newsRepository.findByCategoryIdAndUpdateAtLessThan(categoryId, time);
  }

  public void deleteAll(List<News> news){
    newsRepository.deleteAll(news);
  }
}
