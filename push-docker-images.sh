#!/usr/bin/env bash

docker tag da-sporteezone-java:1.0.0 martiik/da-sporteezone-java:1.0.0

#docker tag da-projekt-do-deploy-java:1.0.0 dolejs/da-projekt-do-deploy-java:1.0.0
##docker tag da-projekt-do-deploy-python:1.0.0 dolejs/da-projekt-do-deploy-python:1.0.0

docker push martiik/da-sporteezone-java:1.0.0
###docker push dolejs/da-projekt-do-deploy-python:1.0.0
