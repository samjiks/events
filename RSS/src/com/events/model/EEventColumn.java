package com.events.model;

public enum EEventColumn
{ 
    EVENTID, TITLE, DESCRIPTION, LINK, CATEGORY, STARTDATE, ENDDATE, ADDRESS, IMAGELINK, IMAGEURL, IMAGETITLE, IMAGEWIDTH, IMAGEHEIGHT ;  //; is required here.
    
    @Override public String toString() {
 
      String sEnumField = super.toString();
      return sEnumField.toLowerCase();
    }
   
}
