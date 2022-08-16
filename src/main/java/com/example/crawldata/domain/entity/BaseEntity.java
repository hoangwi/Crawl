package com.example.crawldata.domain.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class BaseEntity {

  @Field(name = "created_at")
  protected Long createdAt;

  @Field(name = "update_at")
  protected Long updateAt;
}
