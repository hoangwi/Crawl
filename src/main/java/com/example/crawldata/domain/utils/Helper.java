package com.example.crawldata.domain.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
public class Helper {

  public static LocalDateTime convertDateToLocalDateTime(Date date){
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }
}
