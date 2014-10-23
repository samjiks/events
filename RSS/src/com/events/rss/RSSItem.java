package com.events.rss;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/*
 * Represents one RSS item
 */
public class RSSItem
{
  
  private String title;
  private String description;
  private String link;
  private String category;
  private String startDate;
  private String endDate;
  private String imageUrl;
  private String imageTitle;
  private String imageLink;
  private String imageWidth;
  private String imageHeight;
  private String sAddress;
  private String startTime;
  private int eventID;
  
  public int getEventID ()
  {
    return eventID;
  }
  
  public void setEventID (int eventID)
  {
    this.eventID = eventID;
  }
  
  public String getImageLink ()
  {
    return imageLink;
  }
  
  public void setImageLink (String imageLink)
  {
    this.imageLink = imageLink;
  }
  
  public String getImageUrl ()
  {
    return imageUrl;
  }
  
  public void setImageUrl (String imageUrl)
  {
    this.imageUrl = imageUrl;
  }
  
  public String getImageHeight ()
  {
    return imageHeight;
  }
  
  public void setImageHeight (String imageHeight)
  {
    this.imageHeight = imageHeight;
  }
  
  public String getImageWidth ()
  {
    return imageWidth;
  }
  
  public void setImageWidth (String imageWidth)
  {
    this.imageWidth = imageWidth;
  }
  
  public String getImageTitle ()
  {
    return imageTitle;
  }
  
  public void setImageTitle (String imageTitle)
  {
    this.imageTitle = imageTitle;
  }
  
  public String getTitle ()
  {
    return title;
  }
  
  public void setTitle (String title)
  {
    this.title = title;
  }
  
  public String getDescription ()
  {
    return description;
  }
  
  public void setDescription (String description)
  {
    this.description = description;
  }
  
  public String getLink ()
  {
    return link;
  }
  
  public void setLink (String link)
  {
    this.link = link;
  }
  
  public String getCategory ()
  {
    return category;
  }
  
  public void setCategory (String category)
  {
    this.category = category;
  }
  
  public String getStartDate ()
  {
    return startDate;
  }
  
  public void setStartDate (String startDate)
  {
    this.startDate = startDate;
  }
  
  public String getEndDate ()
  {
    return endDate;
  }
  
  public void setEndDate (String endDate)
  {
    this.endDate = endDate;
  }
  
  public String getAddress ()
  {
    return sAddress;
  }
  
  public void setAddress (String sAddress)
  {
    this.sAddress = sAddress;
    
  }
  public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
  
  
  public String toString ()
  {
    return "FeedMessage [title=" +
           title +
           ", description=" +
           description +
           ", link=" +
           link +
           ", category=" +
           category +
           ", startDate=" +
           startDate +
           ", endDate=" +
           endDate +
           ", imageURL=" +
           imageUrl +
           ", imageTitle=" +
           imageTitle +
           "]";
  }


  
}
