package com.events.model;

public enum EHeaderColumn 
{
	TITLE, LINK, DESCRIPTION, LANGUAGE, TTL, LASTBUILDDATE;
    
    @Override public String toString()
    {
 
      String sEnumField = super.toString();
      return sEnumField.toLowerCase();
    }
   

}
