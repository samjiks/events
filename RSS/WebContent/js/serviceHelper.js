var gUrl = "http://localhost:8080/RSS/rest";

 /* The function to get all feed items - ajax request
 * @return an array of items
 * [
 * {
	 * address: event address
	 * category: event category
	 * description: event description
	 * startDate: event start date
	 * endDate: event date
	 * eventId: event id -> integer
	 * link: link to the event
	 * imageHeight: height of image
	 * imageWidth: width of image
	 * imageLink: link to the image
	 * imageTitle: image title
	 * imageUrl: url of image
 * } 
 * ]
 */
function getAllFeedItems() 
{
	return $.ajax(
        {
            type: "GET",
            url: gUrl +'/feed/items',
            data: "{}",
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });

 };
 
 function getFeedItemsByCategory(sCategory) 
 {
   return $.ajax(
         {
             type: "GET",
             url: gUrl + '/feed/category/'+ sCategory,
             data: "{}",
             contentType: "application/json; charset=utf-8",
             dataType: "json"
         });
  };

function getFeedItemsById(sId) 
 {
    return $.ajax(
         {
             type: "GET",
             url: gUrl + '/feed/id/'+sId,
             data: "{}",
             contentType: "application/json; charset=utf-8",
             dataType: "json"
         });
  };
  
 function getAllCategories() 
 {
   return $.ajax(
         {
             type: "GET",
             url: gUrl + '/feed/categories/',
             data: "{}",
             contentType: "application/json; charset=utf-8",
             dataType: "json"
         });
  };
  
  function getbytoday() 
  {
    return $.ajax(
          {
              type: "GET",
              url: gUrl + '/feed/datebytoday',
              data: "{}",
              contentType: "application/json; charset=utf-8",
              dataType: "json"
          });
   };
   
   function getbytomorrow() 
   {
     return $.ajax(
           {
               type: "GET",
               url: gUrl + '/feed/datebytomorrow',
               data: "{}",
               contentType: "application/json; charset=utf-8",
               dataType: "json"
           });
    };
    
    function getbyweekly() 
    {
      return $.ajax(
            {
                type: "GET",
                url: gUrl + '/feed/datebyweek',
                data: "{}",
                contentType: "application/json; charset=utf-8",
                dataType: "json"
            });
     };

