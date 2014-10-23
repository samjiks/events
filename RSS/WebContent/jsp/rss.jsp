<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.events.rss.RSSFeed, com.events.rss.RSSItem;"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
RSSFeed feed = (RSSFeed) request.getAttribute("rssFeed");
int i =0;
for (RSSItem message : feed.getMessages()) {
i++;
%>
	<tr>
		<td><%=i + ") "%><%="Event: " + message.getTitle () %></td>&nbsp;&nbsp;
		<td><%="Category: "+message.getCategory()  %></td>
	</tr>
	<br></br>
	<tr>
		<td><%="Address: " + message.getAddress () %>
		<td>
	</tr>
	<br></br>
	<br></br>
	<%
  }
%>

	<br>

</body>
</html>