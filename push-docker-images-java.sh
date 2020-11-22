#!/usr/bin/env bash

docker tag da-sporteezone-java:1.0.4 martiik/da-sporteezone-java:1.0.4

#docker tag da-projekt-do-deploy-java:1.0.0 dolejs/da-projekt-do-deploy-java:1.0.0
##docker tag da-projekt-do-deploy-python:1.0.0 dolejs/da-projekt-do-deploy-python:1.0.0

###docker push martiik/da-sporteezone-java:tagname

docker push martiik/da-sporteezone-java:1.0.4
###docker push dolejs/da-projekt-do-deploy-python:1.0.0
