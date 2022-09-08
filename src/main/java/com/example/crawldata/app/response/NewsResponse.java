package com.example.crawldata.app.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class NewsResponse {
  private Integer id;
  private Integer categoryId;
  private String title;
  private String link;
  private String description;
  private LocalDateTime publicDate;
}
