package com.example.crawldata.domain.service;

import com.example.crawldata.ModelMapper;
import com.example.crawldata.domain.entity.Sequence;
import com.example.crawldata.domain.storage.CategoryStorage;
import com.example.crawldata.domain.storage.NewsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BaseService {
  @Autowired protected CategoryStorage categoryStorage;
  @Autowired protected NewsStorage newsStorage;
  @Autowired protected MongoOperations mongoOperations;
  @Autowired protected ModelMapper modelMapper;

  public long generateSequence(String seqName) {
    Sequence counter =
      mongoOperations.findAndModify(
        Query.query(Criteria.where("_id").is(seqName)),
        new Update().inc("seq", 1),
        FindAndModifyOptions.options().returnNew(true).upsert(true),
        Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : 1;
  }

}
