package com.events.rss;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRssFeed
{
  
  @Test
  public void testRssItem ()
  {
    final String sTitle = "";
    final String sLink = "";
    final String sDescription = "";
    final String sLanguage = "";
    final String sTtl = "";
    final String sLastBuildDate = "";
    
    final RSSFeed aRssHeader = new RSSFeed(sTitle, sLink, sDescription, sLanguage, sTtl, sLastBuildDate);
    aRssHeader.getMessages ().add (TestRssItem.getItem ());
    
    assertEquals(sTitle,aRssHeader.getTitle ());
    assertEquals(sDescription,aRssHeader.getDescription ());
    assertEquals(sLanguage, aRssHeader.getLanguage ());
    assertEquals(sTtl,aRssHeader.getTtl ());
    assertEquals(sLastBuildDate,aRssHeader.getLastBuildDate ());
    assertEquals(1, aRssHeader.getMessages ().size ());
    assertNotNull (aRssHeader.getMessages ().get (0));

  }
  
}
