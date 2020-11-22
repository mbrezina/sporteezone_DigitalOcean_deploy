#!/usr/bin/env bash

cd java-service
mvn clean package
docker build -t da-sporteezone-java:1.0.4 .


