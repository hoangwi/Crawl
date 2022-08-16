package com.example.crawldata.domain.repository;

import com.example.crawldata.domain.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {
  Category findByTitleAndLink(String title, String Link);

//  List<Category> findAllOrderByIdDesc();
}
