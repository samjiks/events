package com.events.rss;

public class RSSReadTest {
  public static void main(String[] args) {
    final RSSFeedParser parser = new RSSFeedParser("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    RSSFeed feed = parser.parseRSS(20);
  //  System.out.println(feed);
    for (RSSItem message : feed.getMessages()) {
  //  System.out.println(message.getCategory ());
    }

  }
} 