#!/bin/bash

ROOT_PATH="/home/ubuntu/app"
JAR="$ROOT_PATH/app.jar"

# Spring 에러 코드
CONTAINER="app_container"
IMAGE="app_image"

sudo docker build -t "$IMAGE" .
sudo docker run -dp 8080:8080 --name "$CONTAINER" "$IMAGE"