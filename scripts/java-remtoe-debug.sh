#!/bin/bash

java \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 \
-jar "$1"