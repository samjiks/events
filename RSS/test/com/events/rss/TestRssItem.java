package com.events.rss;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRssItem
{
 public static final String sCategory = "Workshops";
 public static final String sDescription ="Teaching the fundamentals of American Swing Dancing, Lindy Hop, with a Social dance.";
 public static final String sLink = "http://www.aberdeencity.gov.uk/xev_EventDetail.asp?id=4480";
 public static final String sStartDate = "2012-06-28 20:00:00";
 public static final String sEndDate = "2012-06-29 02:00:00";
 public static final String sTitle = "Swing Dance";
 public static final String sImageHeight = "179";
 public static final String sImageWidth = "240";
 public static final String sImageUrl = "http://www.aberdeencity.gov.uk";
 public static final String sImageTitle = "Villiers";
 public static final String sImageLink = "http://www.aberdeencity.gov.uk/web/Images/Event/mmFiles/villiers.jpg";
  @Test
  public void testRssItem ()
  {
   
    final RSSItem aRssItem = new RSSItem();
 
    aRssItem.setCategory (sCategory);
    aRssItem.setDescription (sDescription);  
    aRssItem.setLink (sLink);
    aRssItem.setStartDate (sStartDate);
    aRssItem.setEndDate (sEndDate);
    aRssItem.setTitle (sTitle);
    
    aRssItem.setImageHeight (sImageHeight);
    aRssItem.setImageWidth (sImageWidth);
    aRssItem.setImageUrl (sImageUrl);
    aRssItem.setImageTitle (sImageTitle);
    aRssItem.setImageLink (sImageLink);
    
    assertEquals(sCategory,aRssItem.getCategory ());
    assertEquals(sDescription,aRssItem.getDescription ());
    assertEquals(sLink,aRssItem.getLink ());
    assertEquals(sStartDate,aRssItem.getStartDate ());
    assertEquals(sEndDate,aRssItem.getEndDate ());
    assertEquals(sTitle,aRssItem.getTitle ());
    
    assertEquals(sImageHeight,aRssItem.getImageHeight ());
    assertEquals(sImageWidth,aRssItem.getImageWidth ());
    assertEquals(sImageUrl,aRssItem.getImageUrl ());
    assertEquals(sImageTitle,aRssItem.getImageTitle ());
    assertEquals(sImageLink,aRssItem.getImageLink ());

  }
  
  public static RSSItem getItem ()
  {
    final RSSItem aRssItem = new RSSItem();
    
    aRssItem.setCategory (sCategory);
    aRssItem.setDescription (sDescription);  
    aRssItem.setLink (sLink);
    aRssItem.setStartDate (sStartDate);
    aRssItem.setEndDate (sEndDate);
    aRssItem.setTitle (sTitle);
    
    aRssItem.setImageHeight (sImageHeight);
    aRssItem.setImageWidth (sImageWidth);
    aRssItem.setImageUrl (sImageUrl);
    aRssItem.setImageTitle (sImageTitle);
    aRssItem.setImageLink (sImageLink);
    
    return aRssItem;
  }
}
