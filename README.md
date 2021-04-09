# nagp-microservice-stock-trading

run the docker file in below order

docker-compose -f kafka-docker-compose.yaml
docker-compose -f mongo-docker-compose.yaml
docker-compose -f axon-docker-compose.yaml
docker-compose -f logging-docker-compose.yaml
docker-compose -f gateway-docker-compose.yaml
docker-compose -f others-docker-compose.yaml

if it does not create the stock-company-list collection in mongo @ localhost:8081 then create manually and add the data from stock-company-list.json

after everything success application will be avaiable on localhost:9080/api/....
check the gateway application.properties to see all routes.
