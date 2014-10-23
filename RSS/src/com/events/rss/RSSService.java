package com.events.rss;


import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import com.events.model.RSSDatabase;

@Path ("/feed")
public class RSSService
{
  @GET
  @Path ("/items")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getFeedInJSON () throws SQLException
  {
    new RSSDatabase ();
    // RSSDatabase.createEventTable ();
    RSSDatabase.createEventTable ();
    
    final RSSFeedParser parser = new RSSFeedParser ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    parser.parseRSS (20);
    List <RSSItem> aItems = RSSDatabase.SelectAllEvents ();
    RSSDatabase.CloseConnection ();
    return aItems;
  }
  
  @GET
  @Path ("category/{query}")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getItemsByCategory (@PathParam ("query") String query) throws SQLException
  {
    new RSSDatabase ();
    // RSSDatabase.createEventTable ();
    // final RSSFeedParser parser = new RSSFeedParser
    // ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    // parser.parseRSS (20);
    List <RSSItem> aItems  = RSSDatabase.SelectEventsByCategory (query);
    RSSDatabase.CloseConnection ();
    return aItems;
  }
  
  @GET
  @Path ("/datebytoday")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getItemsBydatetoday () throws SQLException
  {
    new RSSDatabase ();
    // RSSDatabase.createEventTable ();
    // final RSSFeedParser parser = new RSSFeedParser
    // ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    // parser.parseRSS (20);
    List <RSSItem> aItems  = RSSDatabase.SelectEventsBydate ();
    RSSDatabase.CloseConnection ();
    return aItems;
  }
  
  @GET
  @Path ("/datebytomorrow")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getItemsBydatebyTomorrow () throws SQLException
  {
    new RSSDatabase ();
    // RSSDatabase.createEventTable ();
    // final RSSFeedParser parser = new RSSFeedParser
    // ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    // parser.parseRSS (20);
    List <RSSItem> aItems  = RSSDatabase.SelectEventsBydatebytomorrow ();
    RSSDatabase.CloseConnection ();
    return aItems;
  }
  
  @GET
  @Path ("datebyweek")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getItemsBydatebyWeek () throws SQLException
  {
    new RSSDatabase ();
    // RSSDatabase.createEventTable ();
    // final RSSFeedParser parser = new RSSFeedParser
    // ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
    // parser.parseRSS (20);
    List <RSSItem> aItems  = RSSDatabase.SelectEventsBydatebyweek ();
    RSSDatabase.CloseConnection ();
    return aItems;
  }
  
  @GET
  @Path ("id/{query}")
  @Produces (MediaType.APPLICATION_JSON)
  public List <RSSItem> getItemById (@PathParam ("query") int query) throws SQLException
  {
    /*
     * space for database query
     */
    new RSSDatabase ();
    List <RSSItem> aItems =  RSSDatabase.SelectAllEventsbyid (query);
    RSSDatabase.CloseConnection ();
    return aItems;
    // return new RSSFeed ("title", "link", "description", "language", "ttl", "lastBuildDate");
  }
  
  @GET
  @Path ("/categories")
  @Produces ({MediaType.APPLICATION_JSON})
  public JSONArray getAllCategories () throws SQLException
  {
     new RSSDatabase ();
    
    List <String> aList = RSSDatabase.selectAllCategories ();
    
    return new JSONArray (aList);
  }
}
