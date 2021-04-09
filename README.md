# nagp-microservice-stock-trading

run the docker file in below order<br/>
Do be in hurry wait until services are up before starting next one.<br/>

docker-compose -f kafka-docker-compose.yaml up <br/>
docker-compose -f mongo-docker-compose.yaml up <br/>
docker-compose -f axon-docker-compose.yaml up <br/>
docker-compose -f logging-docker-compose.yaml up <br/>
docker-compose -f gateway-docker-compose.yaml up <br/>
docker-compose -f others-docker-compose.yaml up <br/>

if it does not create the stock-company-list collection in mongo @ localhost:8081 then create manually and add the data from stock-company-list.json<br/>

after everything success application will be avaiable on localhost:9080/api/....<br/>
check the gateway application.properties to see all routes.
