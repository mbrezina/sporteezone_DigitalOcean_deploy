#!/usr/bin/env bash

docker run --rm -d -p 8080:8080 --name da-sporteezone-java da-sporteezone-java:1.0.1
#docker run --rm -d -p 8080:8080 --name da-projekt-do-deploy-java da-projekt-do-deploy-java:1.0.0
#docker run --rm -d -p 8082:8082 --name da-projekt-do-deploy-python da-projekt-do-deploy-python:1.0.0

###da-projekt-do-deploy-java = da-sporteezone

#<groupId>cz.diribet.czechitas</groupId>
#	<artifactId>do-deploy-java-service</artifactId>
#	<version>0.0.1-SNAPSHOT</version>
#	<name>do-deploy-java-service</name>
