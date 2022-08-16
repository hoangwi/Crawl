package com.example.crawldata.app.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryResponse {
  private Integer id;
  private String title;
  private String link;
  private String description;
  private LocalDateTime lastBuildDate;
//  private String docs;
}
