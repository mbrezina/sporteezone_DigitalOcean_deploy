#!/usr/bin/env bash

docker run --restart always -d -p 8083:8083 --name java dolejs/da-projekt-do-deploy-java:1.0.0
docker run --restart always -d -p 8081:8081 --name js dolejs/da-projekt-do-deploy-js:1.0.0
docker run --restart always -d -p 8082:8082 --name python dolejs/da-projekt-do-deploy-python:1.0.0