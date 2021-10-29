FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq

# Workspace
WORKDIR /usr/udemy

# ADD .jar under target from host
# into this image
ADD ../target/selenium-docker.jar			selenium-docker.jar
ADD ../target/selenium-docker-tests.jar		selenium-docker-tests.jar
ADD ../target/libs							libs
ADD ../src/test/resources					testdata/

# ADD suite files
ADD ../testng-xmls/book-flight-module.xml				book-flight-module.xml
ADD ../testng-xmls/search-module.xml					search-module.xml

# ADD health check script
ADD ../healthcheck/healthcheck.sh                      healthcheck.sh
RUN dos2unix ../healthcheck/healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DSE_EVENT_BUS_HOST=$SE_EVENT_BUS_HOST org.testng.TestNG $MODULE