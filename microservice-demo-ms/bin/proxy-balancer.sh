#!/bin/sh
JAVA="/usr/bin/java"
$JAVA -jar -Xms50m -Xmx100m ../lib/proxy-balancer.jar 2> ../log/proxy-err.log > ../log/proxy.log &

 