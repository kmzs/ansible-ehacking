#!/bin/bash

docker-compose -f /home/user/.sso_advanced/docker-compose.yml down
docker-compose -f /home/user/.sso_advanced/docker-compose.yml up -d