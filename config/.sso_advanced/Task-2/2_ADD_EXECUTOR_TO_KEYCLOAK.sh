#! /bin/bash -e
cp /home/kali/Desktop/Task-2/executor-all-secure-response-types/target/keycloak-spi-client-profile-executor-0.0.1-SNAPSHOT.jar /user/kali/keycloak_data/providers/
docker-compose -f /home/kali/.hidden/docker-compose.yml down
docker-compose -f /home/kali/.hidden/docker-compose.yml up -d