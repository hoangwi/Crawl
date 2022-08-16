package com.example.crawldata.domain.repository;

import com.example.crawldata.domain.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, Integer> {

  News findNewsByCategoryIdAndTitleAndLink(Integer categoryId, String title, String link);

  Page<News> findNewsByCategoryId(Integer categoryId, Pageable pageable);

  List<News> findByCategoryIdAndUpdateAtLessThan(Integer categoryId, Long time);
}
