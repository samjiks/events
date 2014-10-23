package com.events.rss;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Stores head of the RSS feed
 */
@XmlRootElement
public class RSSFeed {

  final String title;
  final String link;
  final String description;
  final String language;
  final String ttl;
  final String lastBuildDate;

  final List<RSSItem> entries = new ArrayList<RSSItem>();

  public RSSFeed(String title, String link, String description, String language,
      String ttl, String lastBuildDate) 
  {
    this.title = title;
    this.link = link;
    this.description = description;
    this.language = language;
    this.ttl = ttl;
    this.lastBuildDate = lastBuildDate;  
  }

  public List<RSSItem> getMessages() {
    return entries;
  }

  public String getTitle() {
    return title;
  }

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }

  public String getLanguage() {
    return language;
  }

  public String getTtl() {
    return ttl;
  }

  public String getLastBuildDate() {
    return lastBuildDate;
  }

  @Override
  public String toString() {
    return "Feed [title=" + title + ", description=" + description
        + ", language=" + language + ", link=" + link + ", lastBuildDate="
        + lastBuildDate + ", ttl=" + ttl + "]";
  }

} 