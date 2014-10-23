package com.events.rss;

import com.events.time.PseudoTime;

public final class RSSHelper
{
  final public static String sVenue = "Venue:";
  final public static String sEventStart = "[Event Start Date:";
  final public static String sDate = "00:00:00Z";
  
  public static String getAddressFromDescription (final String sDescription)
  {
    // NOTE: City could be different than Aberdeen - consider Aberdeenshire instead of Aberdeen?
    if (sDescription.length () == 0)
    {
      System.out.println ("no description");
    }
    
    String sCityCountry = ", Aberdeen, UK";
    
    final int nVenueIndex = sDescription.indexOf (sVenue);
    String sPlace = sDescription.substring (nVenueIndex + sVenue.length () + 1,
                                            sDescription.length () - 1);
    
    if (sPlace.contains ("\n"))
    {
      sPlace = sPlace.replaceAll ("\n", "");
      // System.out.println(sPlace);
    }
    sPlace = sPlace.concat (sCityCountry);
    // System.out.println (sPlace);
    return sPlace;
    
  }
  
  public static String getPureDescription (final String sDescription)
  {
    
    String sPureDescription = "";
    
    if (sDescription.length () == 0)
    {
      return sPureDescription;
    }
    
    if (sDescription.contains (sEventStart))
    {
      final int nEventStartIndex = sDescription.indexOf (sEventStart);
      sPureDescription = sDescription.substring (0, nEventStartIndex);
      
    }
    return sPureDescription;
  }
  
  public static String getCleanDate (String sStartDate)
  {
    
    String sCleanDate = "";
    
    if (sStartDate.length () == 0)
    {
      return sCleanDate;
    }
    
    if (sStartDate.contains (sDate))
    {
      final int nEventStartIndex = sStartDate.indexOf (sDate);
      sCleanDate = sStartDate.substring (0, nEventStartIndex);
      sCleanDate = sCleanDate.trim ();
      // sCleanDate = sCleanDate.concat(PseudoTime.genTime());
    }
    
    // PseudoTime.genTime();
    return sCleanDate;
  }
  
  public static String removeSpaceAtTheEnd (String sCategory)
  {
//    final String sLastChar = sCategory.substring (sCategory.length () - 1);
//    if (sLastChar.contains (" "))
//    {
//      return sCategory = sCategory.substring (0, sCategory.length () - 1);
//    }
//    
    return sCategory.trim ();
  }
}
