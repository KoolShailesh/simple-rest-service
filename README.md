# simple-rest-service
Simple Spring Boot 2 Rest Service 

# Rest EndPooints

1. /greeting 
		This  uses get request,  example of @RequestMapping which returns an POJO Object of Greeting
		
		Curl: curl 'http://localhost:8080/greeting'  

		
2. /instant/instantresponse 
		Another get request and example @GetMapping which returns an Object of MyResponse
		
		Curl: curl 'http://localhost:8080/instant/instantresponse'  

2. /instant/printinstantinput 
		Another get request and example @PostMapping which returns an Object of MyResponse
		
		Curl: curl -H "Content-Type: application/json" --header "Accept: application/json" -d '{"mymessage":"Hello","instant":"2019-10-10T17:26:03.056Z"}' http://localhost:8080/instant/printinstantinput