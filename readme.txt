
Deploy the application in an application server, I used glassfish.Open a browser.Enter the following URL in order to start,stop and see the result of monitoring.

1-start monitoring(POST):
URL format: http://localhost:8080/api_war_exploded/resources/MonitoringApi/start

example request on postman:
POST /api_war_exploded/resources/MonitoringApi/start HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8784364e-1337-7fce-27ee-bece3c45b4d3

{"interval":10,"url":"https://api.test.paysafe.com/accountmanagement/monitor"}


2-stop monitoring(POST):
URL format:http://localhost:8080/api_war_exploded/resources/MonitoringApi/stop

example request on postman:
POST /api_war_exploded/resources/MonitoringApi/stop HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8784364e-1337-7fce-27ee-bece3c45b4d3

{"url":"https://api.test.paysafe.com/accountmanagement/monitor"}

3-see results of tracking(GET):
URL format: http://localhost:8080/api_war_exploded/resources/MonitoringApi/result
output report example:
http://www.google.com Monitor{report={2018/05/28 18:56:28=200, 2018/05/28 18:56:49=200, 2018/05/28 18:57:00=200, 2018/05/28 18:57:10=200, 2018/05/28 18:57:21=200, 2018/05/28 18:57:32=200}}

