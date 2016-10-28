#!/bin/sh
JAVA="/usr/bin/java"
PORT=$1
$JAVA -jar -Xms50m -Xmx100m -Dserver.port=$PORT ../lib/service-login-0.0.1-SNAPSHOT.jar 2> ../log/service-login-$PORT-err.log > ../log/service-login-$PORT.log &
 