package com.example.crawldata.domain.service;

import com.example.crawldata.domain.entity.Category;
import com.example.crawldata.domain.entity.News;
import com.example.crawldata.domain.utils.Helper;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class CrawlDataService extends BaseService {
  private static String URL_POST = "https://www.foxsports.com.au/content-feeds/cycling/";

  public void getData() {
    try {
      URL feedUrl = new URL(URL_POST);

      SyndFeedInput input = new SyndFeedInput();
      SyndFeed syndFeed = input.build(new XmlReader(feedUrl));
      Category category = categoryStorage.findCategoryByTitleAndLink(syndFeed.getTitle(), syndFeed.getLink());
      if (category == null) {
        category = new Category();
        category.setId((int) generateSequence(Category.SEQUENCE_NAME));
        category.setCreatedAt(System.currentTimeMillis());
      }
      category.setTitle(syndFeed.getTitle());
      category.setLink(syndFeed.getLink());
      category.setDescription(syndFeed.getDescription());
      category.setLastBuildDate(Helper.convertDateToLocalDateTime(syndFeed.getPublishedDate()));
      category.setDocs(syndFeed.getDocs());
      category.setUpdateAt(System.currentTimeMillis());
      category = categoryStorage.save(category);
      log.info("channel============" + category);

      List<News> newsList = new ArrayList<>();

      for (SyndEntry syndEntry : syndFeed.getEntries()) {

        News news = newsStorage.findNewsByCategoryIdAndTitleAndLink(category.getId(), syndEntry.getTitle(), syndEntry.getLink());
        if (news == null) {
          news = new News();
          news.setId((int) generateSequence(News.SEQUENCE_NAME));
          news.setCreatedAt(System.currentTimeMillis());
        }

        news.setCategoryId(category.getId());
        news.setTitle(syndEntry.getTitle());
        news.setLink(syndEntry.getLink());
//        Map<String, String> properties = new HashMap<>();

        Document document = Jsoup.parse(syndEntry.getDescription().getValue());
        news.setDescription(String.valueOf(document.getElementsByTag("p")));
        news.setPublicDate(Helper.convertDateToLocalDateTime(syndEntry.getPublishedDate()));
        news.setUpdateAt(System.currentTimeMillis());

        newsList.add(news);
      }

      newsStorage.saveAll(newsList);

      //Todo delete channels and news dont use
      deleteNews(category.getId());
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  public void deleteNews(int categoryId){

    //Todo time = now - 1h
    Long time = System.currentTimeMillis() - 3600 * 1000; //Thoi gian 1h truoc
    List<News> newsList = newsStorage.findByCategoryIdAndUpdateAtLessThan(categoryId, time);
    if(newsList != null){
      newsStorage.deleteAll(newsList);
    }
  }

}
