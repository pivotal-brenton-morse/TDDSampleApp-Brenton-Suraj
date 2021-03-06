#!/bin/bash

echo "Installing Xtreme rest library..."
mvn -q install:install-file -DgroupId=com.xtreme.rest -DartifactId=xl-rest \
	-Dversion=2.0.4 -Dpackaging=jar -Dfile="extras/xl-rest_lib-android-v2.0.4.jar"

echo "Installing Xtreme network library..."
mvn -q install:install-file -DgroupId=com.xtreme.network -DartifactId=xtreme-network \
	-Dversion=1.5 -Dpackaging=jar -Dfile="extras/xl-network_lib-android-v1.5.jar"

echo "Installing Xtreme threading library..."
mvn -q install:install-file -DgroupId=com.xtreme.threadingLib -DartifactId=xl-threading \
	-Dversion=1.1.1 -Dpackaging=jar -Dfile="extras/xl-threading_lib-android-v1.1.1.jar"

