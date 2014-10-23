package com.events.rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import com.events.model.RSSDatabase;

/*
 * Reads RSS feed from the given link
 */

public class RSSFeedParser
{
  
  final URL url;
  
  public RSSFeedParser (String feedUrl)
  {
    try
    {
      this.url = new URL (feedUrl);
    }
    catch (MalformedURLException e)
    {
      throw new RuntimeException (e);
    }
  }
  
  public RSSFeed parseRSS (final int nLimitEntries)
  {
    RSSFeed feed = null;
 
    try
    {
      
      boolean isFeedHeader = true;
      // Set header values intial to the empty string
      String sDescription = "";
      String sTitle = "";
      String sLink = "";
      String sLanguage = "";
      String sTtl = "";
      String sLastBuildDate = "";
      String sCategory = "";
      String sStartDate = "";
      String sEndDate = "";
      String sImageUrl = "";
      String sImageTitle = "";
      String sImageLink = "";
      String sImageWidth = "";
      String sImageHeight = "";
      String sAddress = "";
      int nEventId = 0;
      boolean bFirstItem = true;
      // First create a new XMLInputFactory
      XMLInputFactory inputFactory = XMLInputFactory.newInstance ();
      // Setup a new eventReader
      InputStream in = read ();
      XMLEventReader eventReader = inputFactory.createXMLEventReader (in);
      // Read the XML document
      while (eventReader.hasNext ())
      {
           
        XMLEvent event = eventReader.nextEvent ();
        
        if (event.isStartElement ())
        {
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.ITEM))
          {
            if (isFeedHeader)
            {
              isFeedHeader = false;
              feed = new RSSFeed (sTitle, sLink, sDescription, sLanguage, sTtl, sLastBuildDate);
              // TODO: WE CHECK IF LAST BUILD DATE IS THE SAME AS IN TABLE RRSHEAD
              // IF NOT UPDATE LAST BUILD DATE DROP TABLE AND INSERT EVENTS
              // IF ITS THE SAME DO NOTHING
              // RSSDatabase.insertRSSHeader(sTitle, sLink, sDescription, sLanguage, sTtl,
              // sLastBuildDate);
              
            }
            event = eventReader.nextEvent ();
            continue;
          }
          
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.TITLE))
          {
            event = eventReader.nextEvent ();
            sTitle = event.asCharacters ().getData ();
            
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.DESCRIPTION))
          {
            
            event = eventReader.nextEvent ();
            sDescription = event.asCharacters ().getData ();
            if (sDescription.contains (RSSHelper.sVenue))
            {
              sAddress = RSSHelper.getAddressFromDescription (sDescription);
              // System.out.println (sAddress);
            }
            sDescription = RSSHelper.getPureDescription (sDescription);
            continue;
          }
          
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.LINK))
          {
            event = eventReader.nextEvent ();
            sLink = event.asCharacters ().getData ();
            continue;
          }
          
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.START_DATE))
          {
            event = eventReader.nextEvent ();
            sStartDate = event.asCharacters ().getData ();
            sStartDate = RSSHelper.getCleanDate (sStartDate);
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.END_DATE))
          {
            event = eventReader.nextEvent ();
            sEndDate = event.asCharacters ().getData ();
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.LANGUAGE))
          {
            event = eventReader.nextEvent ();
            sLanguage = event.asCharacters ().getData ();
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.CATEGORY))
          {
            event = eventReader.nextEvent ();
            try
            {
              sCategory = event.asCharacters ().getData ();
              sCategory = RSSHelper.removeSpaceAtTheEnd(sCategory);
            }
            catch (Exception e)
            {
              sCategory = "undefined";
            }
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.LAST_BUILD_DATE))
          {
            event = eventReader.nextEvent ();
            sLastBuildDate = event.asCharacters ().getData ();
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.LAST_BUILD_DATE))
          {
            event = eventReader.nextEvent ();
            sLastBuildDate = event.asCharacters ().getData ();
            continue;
          }
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.TTL))
          {
            event = eventReader.nextEvent ();
            sTtl = event.asCharacters ().getData ();
            continue;
          }
          
          // getting values of the 'image' tag
          if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.IMAGE))
          {
            while (!(event.isEndElement () && event.asEndElement ().getName ().getLocalPart () == (CRSSTags.IMAGE)))
            {
              event = eventReader.nextEvent ();
              if (event.isStartElement ())
              {
                if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.URL))
                {
                  event = eventReader.nextEvent ();
                  sImageUrl = event.asCharacters ().getData ();
                  continue;
                }
                if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.TITLE))
                {
                  event = eventReader.nextEvent ();
                  sImageTitle = event.asCharacters ().getData ();
                  continue;
                }
                if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.LINK))
                {
                  event = eventReader.nextEvent ();
                  sImageLink = event.asCharacters ().getData ();
                  continue;
                }
                if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.WIDTH))
                {
                  event = eventReader.nextEvent ();
                  sImageWidth = event.asCharacters ().getData ();
                  continue;
                }
                if (event.asStartElement ().getName ().getLocalPart () == (CRSSTags.HEIGHT))
                {
                  event = eventReader.nextEvent ();
                  sImageHeight = event.asCharacters ().getData ();
                  continue;
                }
              }
            }
          }
        }
        
        else if (event.isEndElement ())
        {
          if (event.asEndElement ().getName ().getLocalPart () == (CRSSTags.ITEM))
          {
          

            RSSDatabase.insertEvent (nEventId,
                                     sTitle,
                                     sDescription,
                                     sLink,
                                     sCategory,
                                     sStartDate,
                                     sEndDate,
                                     sAddress,
                                     sImageLink,
                                     sImageUrl,
                                     sImageTitle,
                                     sImageWidth,
                                     sImageHeight);
              nEventId++;

            if(nEventId >= nLimitEntries)
              break;
           
            event = eventReader.nextEvent ();
            continue;
          }
        }
      }
    }
    catch (XMLStreamException e)
    {
      throw new RuntimeException (e);
    }
    return feed;
    
  }
  
  private InputStream read ()
  {
    try
    {
      return url.openStream ();
    }
    catch (IOException e)
    {
      throw new RuntimeException (e);
    }
  }
}
