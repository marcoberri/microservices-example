#!/bin/sh
mvn clean package
cp target/service-login*.jar ../../microservice-demo-ms/lib/
