package com.example.crawldata.domain.entity;

import com.example.crawldata.domain.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "category")
public class Category extends BaseEntity {

  @Transient
  public static final String SEQUENCE_NAME = "category_sequence";
  @Id
  private Integer id;

  @Field(name = "title")
  private String title;

  @Field(name = "link")
  private String link;

  @Field(name = "description")
  private String description;

  @Field(name = "last_build_date")
  private LocalDateTime lastBuildDate;

  @Field(name = "docs")
  private String docs;

}
