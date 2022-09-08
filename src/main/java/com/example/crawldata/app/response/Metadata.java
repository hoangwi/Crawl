package com.example.crawldata.app.response;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Metadata {
  private final long total;
  private final long totalPages;

  public static Metadata createFrom(Page page) {
    return new Metadata(page.getTotalElements(), page.getTotalPages());
  }
}