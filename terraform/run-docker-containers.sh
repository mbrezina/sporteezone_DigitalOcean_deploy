#!/usr/bin/env bash

docker run --restart always -d -p 8080:8080 --name java martiik/da-sporteezone-java:1.0.1
#docker run --restart always -d -p 8080:8080 --name java martiik/da-sporteezone-java:1.0.0

##docker run --restart always -d -p 8083:8083 --name java dolejs/da-projekt-do-deploy-java:1.0.0

docker run --rm -d -p 8082:8082 --name python martiik/da-sporteezone-python:1.0.0
