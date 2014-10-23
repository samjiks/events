package com.events.rss;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRssHelper
{


  @Test
  public void testRssHelper ()
  {
    //NOTE: Description always finish with ']' char
    
    final String sDescription = "[Contemporary Scottish Jazz with Paul Harrison on organ, " +
    		"Graeme Stephen, guitar and Chris Wallace on drums <br />" +
    		"[Event Start Date:2012-11-01 00:00:00Z; End Date:2012-11-01 00:00:00Z; " +
    		"Venue: The Blue Lamp]";
        
    final String sAddress = RSSHelper.getAddressFromDescription (sDescription);
    assertEquals("The Blue Lamp, Aberdeen, UK", sAddress);
  }
  
  
}
