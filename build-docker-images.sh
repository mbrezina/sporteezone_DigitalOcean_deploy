#!/usr/bin/env bash

cd java-service
mvn clean package
docker build -t da-projekt-do-deploy-java:1.0.0 .

cd ../js-service
docker build -t da-projekt-do-deploy-js:1.0.0 .

cd ../python-service
docker build -t da-projekt-do-deploy-python:1.0.0 .
