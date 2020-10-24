#!/usr/bin/env bash

# Exit if any of the intermediate steps fail
set -e

# Print commands
set -x

sudo apt-get -qq update
sudo apt-get -qq --yes install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

sudo apt-get -qq update
sudo apt-get -qq install -y docker-ce

sudo usermod -a -G docker root