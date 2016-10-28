#!/bin/sh
mvn clean package
cp target/service-user*.jar ../../microservice-demo-ms/lib/
