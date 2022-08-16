package com.example.crawldata.schedule;

import com.example.crawldata.domain.service.CrawlDataService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CrawlDataSchedule {
  @Autowired
  private CrawlDataService crawlDataService;

  @Scheduled(cron = "0 */1 * * * *")
  public void processorGetData() {
    log.info("=================== get data ");
    crawlDataService.getData();
  }
}
