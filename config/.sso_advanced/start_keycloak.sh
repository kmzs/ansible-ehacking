#!/bin/bash
set -e

# determine docker compose command
if command -v docker &>/dev/null && docker --help | grep -q "compose"; then
    DOCKER_COMPOSE="docker compose"
else
    DOCKER_COMPOSE="docker-compose"
fi

# load .env if present
[ -f .env ] && set -o allexport && . .env && set +o allexport

cd "$HOME/.sso_advanced"
$DOCKER_COMPOSE down
$DOCKER_COMPOSE pull
docker system prune -f
$DOCKER_COMPOSE up -d