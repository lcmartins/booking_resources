# booking of resources
this is an example of springboot microservice used to book resources
it is intented to book a resource in a date/hour and is expected that dont book the same resource in the same date/hour (basically)

To run the project you must do the following:
1. have an instance of sqlserver available or create one with the following docker command:

      docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=14042002@lc" \
         -p 1433:1433 --name SQLDB01 \
         -d mcr.microsoft.com/mssql/server:2017-latest
   
2. Run the scripts inside resources\scripts-sql
3. Go to a browser copy and paste the bellow url:
    http://localhost:7080/resource
4. to book a resource call the url: http://localhost:7080/booking with the following object in a post method:
  
   {
	"beginMiliseconds": 1570330809000,
	"endMiliseconds": 1570338009000,
	"user": {
		"id": 1
	},
	"resource": {
		"id": 2
	}
}
  
5. to see the result of the step 4 go to http://localhost:7080/booking?data=2019-10-06, the parameter data is a filter to get all resources booked to that date.
