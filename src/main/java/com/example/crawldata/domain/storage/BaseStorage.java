package com.example.crawldata.domain.storage;

import com.example.crawldata.domain.repository.CategoryRepository;
import com.example.crawldata.domain.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseStorage {
   @Autowired protected CategoryRepository categoryRepository;
   @Autowired protected NewsRepository newsRepository;
}
