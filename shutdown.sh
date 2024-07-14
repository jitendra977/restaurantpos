#!/bin/bash

# Find the process ID (PID) of the Java process started by Maven
PID=$(ps aux | grep '[j]ava.*spring-boot' | awk '{print $2}')

if [ -n "$PID" ]; then
  echo "Stopping process with PID $PID"
  kill -9 $PID
else
  echo "No running process found for mvn spring-boot:run"
fi
