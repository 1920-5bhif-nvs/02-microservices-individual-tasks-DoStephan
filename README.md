application.properties
```
quarkus.http.port = 8090
at.htl.microservice.PersonService/mp-rest/url = http://localhost:8080/api/person
at.htl.microservice.PersonService/mp-rest/scope=javax.inject.Singleton
```

https://quarkus.io/guides/rest-client-guide
```
./mvnw quarkus:add-extension -Dextensions="rest-client"
```
https://quarkus.io/guides/metrics-guide
```
./mvnw quarkus:add-extension -Dextensions="metrics"
```
https://quarkus.io/guides/health-guide
```
./mvnw quarkus:add-extension -Dextensions="health"
```
https://quarkus.io/guides/fault-tolerance-guide
```
./mvnw quarkus:add-extension -Dextensions="smallrye-fault-tolerance"
```

## Prometheus

Prometheus is an open-source systems monitoring and alerting toolkit.
The project has a very active developer and user community. It is now a standalone open source project and maintained independently of any company.

## Istio

Istio is an open platform-independent service mesh that provides traffic management, policy enforcement, and telemetry collection.
Istio is designed to manage communications between microservices and applications. Without requiring changes to the underlying services.