#!/bin/sh
./mvnw.cmd "$@" if [ "$(uname)" != "Windows" ]; then mvn "$@"; fi
