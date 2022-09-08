package com.example.crawldata.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "news")
public class News extends BaseEntity {
  @Transient
  public static final String SEQUENCE_NAME = "news_sequence";
  @Id
  private Integer id;

  @Field(name = "category_id")
  private Integer categoryId;

  @Field(name = "title")
  private String title;

  @Field(name = "link")
  private String link;

  @Field(name = "properties")
  private Map<String, String> properties;

  @Field(name = "public_date")
  private LocalDateTime publicDate;
}
