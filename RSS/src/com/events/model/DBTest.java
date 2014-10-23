package com.events.model;

import java.sql.SQLException;
import java.util.List;

import com.events.rss.RSSFeed;
import com.events.rss.RSSFeedParser;
import com.events.rss.RSSItem;

public class DBTest
{
  
  /**
   * @param args
   * @throws SQLException 
   */
  public static void main (String [] args) throws SQLException
  {
    RSSDatabase rd = new RSSDatabase ();
    RSSDatabase.createEventTable ();
    final RSSFeedParser parser = new RSSFeedParser ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    parser.parseRSS (20);
   // List <RSSItem> aItems =  RSSDatabase.SelectAllEvents ();
    List <String> aItems =  RSSDatabase.selectAllCategories ();
    System.out.println(aItems.toString ());
//    List <RSSItem> aItems =  RSSDatabase.SelectEventsByCategory ("Countryside");
//    for (RSSItem aItem : aItems)
//    {
//      System.out.print (aItem.getEventID ()+" " +aItem.getTitle () +"\n");
//    }
  }
  
}
