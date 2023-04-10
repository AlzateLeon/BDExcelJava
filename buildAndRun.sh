#!/bin/sh
if [ $(docker ps -a -f name=prueba | grep -w prueba | wc -l) -eq 1 ]; then
  docker rm -f prueba
fi
mvn clean package && docker build -t com.excelbd/prueba .
docker run -d -p 9080:9080 -p 9443:9443 --name prueba com.excelbd/prueba
