#!/bin/sh
JAVA="/usr/bin/java"
$JAVA -jar -Xms50m -Xmx256m -Dspring.profiles.active=default ../lib/eureka-0.0.1-SNAPSHOT.jar 2> ../log/eureka-err.log > ../log/eureka.log &
 