#!/bin/sh
mvn clean package
cp target/proxy-balancer*.jar ../../microservice-demo-ms/lib/
