#!/bin/sh
mvn clean package
cp target/eureka-*.jar ../../microservice-demo-ms/lib/
