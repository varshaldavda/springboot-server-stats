Challenge

Create a web server with two endpoints:

Endpoint 1 (/process/*)

This endpoint must accept HTTP request sent using any of the methods (GET, POST, PUT, DELETE) and respond back with a JSON describing the request. To be specific the response JSON must contain the following fields

{
   time: //time when the request was received,
   method: //HTTP method used for making the request,
   headers: //HTTP headers in the request,
   path: //request path (will start with /process),
   query: //the parsed query string as key-values, if any
   body: //request body, if any
   duration: //time taken to process the request
}
You are to wait randomly between 15 to 30 seconds before sending back a response to any request. The random response time you choose is what needs to be populated in the duration field.

Endpoint 2 (/stats)

This endpoint must respond with the following real time statistics:

Total number of requests made since server startup and the average response time, classified by HTTP method.
Active number of requests, classified by HTTP method (eg: 3 GET requests, 4 POST requests, 5 PUT requests)
Number of requests and average response times, in the past hour, classified by HTTP method
Number of requests and average response times, in the past minute, classified by HTTP method
Here are somethings we're watching out for:

Code A clean and simple to follow codebase simply melts us.
Hosting Hosting the solution on the internet so that it's publicly accessible will be awesome.
Persistence Optional, but great if your stats dont reset themselves on the occassion of a server restart.
Websockets Optional, but a big big plus, and we are talking about the /stats endpoint. In this case, the /stats page will be reporting realtime statistics without having to refresh the page.
If you're up for the challenge, fork this repository and complete your entire solution there. Feel free to use any stack of your choice, and we're open to partial feature submissions as well. Just see it as an opportunity to know each other technically.

Happy hacking, and have fun!