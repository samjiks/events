package com.events.model;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import com.events.rss.RSSFeedParser;
import com.events.rss.RSSItem;
import com.events.time.PseudoTime;

public class RSSDatabase
{
	static Connection connection = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	public static final String EVENTS_TABLE = "events";
	public static final String HEADER_TABLE = "tRSSHeader";
	static Connection connection1;
	static SimpleDateFormat dateFormat1 = new SimpleDateFormat ("yyy-MM-dd 00:00:00'Z'");
	static SimpleDateFormat dateFormat = new SimpleDateFormat ("yyy-MM-dd");

	public RSSDatabase ()
	{
		try
		{
			connection = getConnection ();
		}
		catch (Exception e)
		{
			System.out.println ("Error in RSSDatabase Constructor class" + e.getMessage ());
		}
	}
	public static Connection getConnection () throws URISyntaxException,
	SQLException,
	ClassNotFoundException
	{
		Properties props = new Properties ();
		String url = "jdbc:postgresql://ec2-54-243-190-56.compute-1.amazonaws.com:5432/dc10bc53fs1nl1";

		try
		{
			Class.forName ("org.postgresql.Driver");
			props = new Properties ();
			props.setProperty ("user", "tacuyfkorcgmur");
			props.setProperty ("password", "dnCIB5eXGLaqafAkB4rpa4UQyj");
			props.setProperty ("ssl", "true");
			props.setProperty ("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		}
		catch (Exception e)
		{
			System.out.println ("SQL Connection driver Problem:" + e.getMessage ());

		}
		return connection = DriverManager.getConnection (url, props);
	}

	/*  public static Connection getConnection () throws URISyntaxException,
                                           SQLException,
                                           ClassNotFoundException
  {
    Properties props = new Properties ();
    String url = "jdbc:postgresql://ec2-54-243-125-2.compute-1.amazonaws.com:5432/dfdjescm99a9ru";

    try
    {
      Class.forName ("org.postgresql.Driver");
      props = new Properties ();
      props.setProperty ("user", "uiwcybidzyyyvz");
      props.setProperty ("password", "WHqML5Bf8li0sBpTknnOrCi5ax");
      props.setProperty ("ssl", "true");
      props.setProperty ("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
    }
    catch (Exception e)
    {
      System.out.println ("SQL Connection driver Problem:" + e.getMessage ());

    }
    return connection = DriverManager.getConnection (url, props);
  }*/

	public static void createRSSHeadTable ()
	{
		try
		{
			stmt = connection.createStatement ();
			stmt.executeUpdate ("DROP TABLE IF EXISTS tRSSHeader");
			String querytabcreate = "CREATE TABLE tRSSHeader (TITLE text, LINK text, DESCRIPTION text, LANGUAGE text, TTL text, LASTBUILDDATE text)";
			stmt.executeUpdate (querytabcreate);
		}
		catch (SQLException e)
		{
			System.out.println ("Error Message" + e.getMessage ());
		}

	}

	public static void createEventTable ()
	{
		try
		{
			stmt = connection.createStatement ();
			stmt.executeUpdate ("DROP TABLE IF EXISTS events");

			String querytabcreate = "CREATE TABLE events (" +
					EEventColumn.EVENTID.toString () +
					" int2, title text, description text, category text, startDate text, startTime text, enddate text, address text, link text, imageurl text, imagelink text, imageheight text, imagewidth text, imagetitle text)";
			stmt.executeUpdate (querytabcreate);
		}
		catch (SQLException e)
		{
			System.out.println ("Error Message" + e.getMessage ());
		}

	}

	// TODO: Create function to get Event by Id (SELECT)
	// TODO: Create function to get Today Events (1)
	// TODO: Create function to get Tomorrow Events (2)
	// TODO: Create function to get Week Events (3)
	// 1/2/3 could be one function with switch case:

	public static void insertEvent (final int nEventId,
			final String sTitle,
			final String sDescription,
			final String sLink,
			final String sCategory,
			final String sStartDate,
			final String sEndDate,
			final String sAddress,
			final String sImageLink,
			final String sImageUrl,
			final String sImageTitle,
			final String sImageWidth,
			final String sImageHeight)
	{
		try
		{
			ps = connection.prepareStatement ("INSERT INTO events (" +
					EEventColumn.EVENTID.toString () +
					", " +
					EEventColumn.TITLE.toString () +
					", " +
					EEventColumn.DESCRIPTION.toString () +
					", " +
					EEventColumn.LINK.toString () +
					", " +
					EEventColumn.CATEGORY.toString () +
					", " +
					EEventColumn.STARTDATE.toString () +
					", " +
					EEventColumn.ENDDATE.toString () +
					", " +
					EEventColumn.ADDRESS.toString () +
					"," +
					EEventColumn.IMAGELINK.toString () +
					", " +
					EEventColumn.IMAGEURL.toString () +
					", " +
					EEventColumn.IMAGETITLE.toString () +
					", " +
					EEventColumn.IMAGEWIDTH.toString () +
					", " +
					EEventColumn.IMAGEHEIGHT.toString () +
					") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt (1, nEventId);
			ps.setString (2, sTitle);
			ps.setString (3, sDescription);
			ps.setString (4, sLink);
			ps.setString (5, sCategory);
			ps.setString (6, sStartDate);
			ps.setString (7, sEndDate);
			ps.setString (8, sAddress);
			ps.setString (9, sImageLink);
			ps.setString (10, sImageUrl);
			ps.setString (11, sImageTitle);
			ps.setString (12, sImageWidth);
			ps.setString (13, sImageHeight);
			ps.executeUpdate ();

		}
		catch (Exception e)
		{
			System.out.println ("Problem:" + e.getMessage ());
		}

	}

	public static void insertEventsToDb ()
	{
		createRSSHeadTable ();
		createEventTable ();
		final RSSFeedParser parser = new RSSFeedParser ("http://www.aberdeencity.gov.uk/accapps/rss/EventRSS.aspx");
		parser.parseRSS (20);
	}

	public static List <RSSItem> SelectEventsByCategory (final String sCategory) throws SQLException
	{
		
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		String selectSQL = "SELECT * FROM " +
				EVENTS_TABLE +
				" WHERE " +
				EEventColumn.CATEGORY.toString () +
				"= ?";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);
		aStatement.setString (1, sCategory);
		ResultSet rs = aStatement.executeQuery ();

		aItemList = getItemsFromResultSet (rs);

		return aItemList;
	}

	public static List <RSSItem> SelectEventsBydate () throws SQLException
	{
		//RSSDatabase rssd = new RSSDatabase();
		Calendar calendartoday = Calendar.getInstance ();
	//	calendartoday.add (Calendar.DAY_OF_MONTH, 2);
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		String selectSQL = "SELECT * FROM " +
				EVENTS_TABLE +
				" WHERE " +
				EEventColumn.STARTDATE.toString () +
				"= ?";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);
		aStatement.setString (1, dateFormat.format(calendartoday.getTime()));
		ResultSet rs = aStatement.executeQuery ();
/*		while (rs.next ())
		{
			System.out.println("test");
			sStartdate = rs.getString ("startdate");
			sTitle = rs.getString ("title");
			System.out.println (sTitle + "," + sStartdate);
		}*/

		aItemList = getItemsFromResultSet (rs);

		return aItemList;
	}

	public static List <RSSItem> SelectEventsBydatebytomorrow () throws SQLException
	{
		//RSSDatabase rssd = new RSSDatabase();
		Calendar calendartoday = Calendar.getInstance ();
        calendartoday.add (Calendar.DAY_OF_MONTH, 1);
		System.out.println("test");
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		String selectSQL = "SELECT * FROM " +
				EVENTS_TABLE +
				" WHERE " +
				EEventColumn.STARTDATE.toString () +
				"= ?";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);
		aStatement.setString (1, dateFormat.format(calendartoday.getTime()));
		ResultSet rs = aStatement.executeQuery ();
/*		while (rs.next ())
		{
			System.out.println("test");
			sStartdate = rs.getString ("startdate");
			sTitle = rs.getString ("title");
			System.out.println (sTitle + "," + sStartdate);
		}*/

		aItemList = getItemsFromResultSet (rs);

		return aItemList;
	}
	public static List <RSSItem> SelectEventsBydatebyweek () throws SQLException
	{
	//	RSSDatabase rssd = new RSSDatabase();
		Calendar calendartoday = Calendar.getInstance ();
		Calendar calendarweek = Calendar.getInstance ();
	     calendarweek.add (Calendar.DAY_OF_MONTH, 7);
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		String selectSQL = "SELECT * FROM  events WHERE startdate between ? AND ?";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);
		aStatement.setString (1, dateFormat.format(calendartoday.getTime()));
		aStatement.setString (2, dateFormat.format(calendarweek.getTime()));
		ResultSet rs = aStatement.executeQuery ();
	/*	String sStartdate = null;
		String sTitle = null;
		while (rs.next ())
		{
			sStartdate = rs.getString ("startdate");
			sTitle = rs.getString ("title");
			System.out.println (sTitle + "," + sStartdate);
		}*/

		aItemList = getItemsFromResultSet (rs);
		
		return aItemList;
	}
	public static List <RSSItem> SelectAllEvents () throws SQLException
	{
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		// int i = 0;
		Statement s = connection.createStatement ();
		s.setMaxRows (100);
		// TODO SAM: Please change the statement as it is done in SelectEventsByCategory
		// It will prevent sql injections
		ResultSet rs = s.executeQuery ("select * from " + EVENTS_TABLE);
		for (;;)
		{

			aItemList = getItemsFromResultSet (rs);
			if ((s.getMoreResults () == false) && (s.getUpdateCount () == -1))
			{
				break;
			}
		}
		return aItemList;
	}

	public static List <String> selectAllCategories () throws SQLException
	{
		List <String> aItemList = new ArrayList <String> ();
		// int i = 0;Select distinct category from events 
		String selectSQL = "Select distinct category From events";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);

		ResultSet rs = aStatement.executeQuery ();
		while (rs.next ())
		{
			aItemList.add (rs.getString (EEventColumn.CATEGORY.toString ()));
		}
		return aItemList;
	}


	public static List <RSSItem> SelectAllEventsbyid (int query) throws SQLException
	{
		List <RSSItem> aItemList = new ArrayList <RSSItem> ();
		// int i = 0;
		String selectSQL = "select * from " +
				EVENTS_TABLE +
				" WHERE " +
				EEventColumn.EVENTID.toString () +
				"= ?";
		PreparedStatement aStatement = connection.prepareStatement (selectSQL);
		aStatement.setInt (1, query);
		ResultSet rs = aStatement.executeQuery ();
		Statement s = connection.createStatement ();
		aItemList = getItemsFromResultSet (rs);

		return aItemList;

	}

	private static ArrayList <RSSItem> getItemsFromResultSet (final ResultSet rs) throws SQLException
	{
		ArrayList <RSSItem> aItemList = new ArrayList <RSSItem> ();
		while (rs.next ())
		{
			RSSItem message = new RSSItem ();

			message.setEventID (Integer.parseInt (rs.getString (EEventColumn.EVENTID.toString ())));
			message.setDescription (rs.getString (EEventColumn.DESCRIPTION.toString ()));
			message.setLink (rs.getString (EEventColumn.LINK.toString ()));
			message.setTitle (rs.getString (EEventColumn.TITLE.toString ()));
			message.setStartDate (rs.getString (EEventColumn.STARTDATE.toString ()));
			message.setEndDate (rs.getString (EEventColumn.ENDDATE.toString ()));
			message.setCategory (rs.getString (EEventColumn.CATEGORY.toString ()));

			message.setImageLink (rs.getString (EEventColumn.IMAGELINK.toString ()));
			message.setImageUrl (rs.getString (EEventColumn.IMAGEURL.toString ()));
			message.setImageTitle (rs.getString (EEventColumn.IMAGETITLE.toString ()));
			message.setImageWidth (rs.getString (EEventColumn.IMAGEWIDTH.toString ()));
			message.setImageHeight (rs.getString (EEventColumn.IMAGEHEIGHT.toString ()));

			message.setAddress (rs.getString (EEventColumn.ADDRESS.toString ()));
			message.setStartTime(PseudoTime.genTime());
			aItemList.add (message);
		}
		return aItemList;
	}

	public static void insertRSSHeader (final String sTitle,
			final String sLink,
			final String sDescription,
			final String sLanguage,
			final String sTtl,
			final String sLastBuildDate)
	{
		try
		{
			// TODO SAM: use enum for title, link in the statement as in the statement insertEvent()
		ps = connection.prepareStatement ("INSERT INTO tRSSHeader(TITLE, LINK, DESCRIPTION, LANGUAGE, TTL, LASTBUILDDATE) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString (1, sTitle);
		ps.setString (2, sDescription);
		ps.setString (3, sLink);
		ps.setString (4, sLanguage);
		ps.setString (5, sTtl);
		ps.setString (6, sLastBuildDate);

		ps.executeUpdate ();

		}
		catch (Exception e)
		{
			System.out.println ("Problem Inserting RSS Header:" + e.getMessage ());
		}

		CloseConnection ();
	}

	public static void CloseConnection ()
	{
		try
		{
			if (rs != null)
			{
				rs.close ();
			}
			if (stmt != null)
			{
				stmt.close ();
			}
			if (connection != null)
			{
				connection.close ();
			}
		}
		catch (SQLException e)
		{
			System.out.println ("Sql Exception" + e.getMessage ());
		}
	}



	public static void main (String argsp[]) throws SQLException
	{
	 SelectEventsBydatebyweek();
	}

	



	

}
