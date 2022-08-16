package com.example.crawldata.domain.storage;

import com.example.crawldata.domain.entity.Category;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class CategoryStorage extends BaseStorage{

  public Category save(Category category){
    log.debug("==== channel" + category);
    return categoryRepository.save(category);
  }

  public Category findCategoryByTitleAndLink(String title, String link){
    return categoryRepository.findByTitleAndLink(title, link);
  }

  public List<Category> findAllOrderByIdDesc(){
    return categoryRepository.findAll();
  }


}
