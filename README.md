# simple-rest-service
Simple Spring Boot 2 Rest Service 

# Rest EndPooints

1. /greeting 
		This  uses get request,  example of @RequestMapping which returns an POJO Object of Greeting
		
		Curl: curl 'http://localhost:8080/greeting'  

		
2. /instant/instantresponse 
		Another get request and example @GetMapping which returns an Object of MyResponse
		
		Curl: curl 'http://localhost:8080/instant/instantresponse'  

3. /instant/printinstantinput 
		Another get request and example @PostMapping which returns an Object of MyResponse
		
		Curl: curl -H "Content-Type: application/json" 
		--header "Accept: application/json" 
		-d '{"mymessage":"Hello","instant":"2019-10-10T17:26:03.056Z"}' http://localhost:8080/instant/printinstantinput
		
		
4./ 
		Curl: curl 'http://localhost:8080/localdatetime/localdateresponse' 
		
5. /localdatetime/printilocaldateInput


         Cur: curl -H "Content-Type: application/json"  --header "Accept: application/json" -d '{"mymessage":"Hello.... ","localdate":"17-10-2019","localdatetime":"17-10-2019 14:04:53"}' http://localhost:8080/localdatetime/printilocaldateInput
