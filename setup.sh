#!/bin/bash

echo "Installing Xtreme rest library..."
mvn -q install:install-file -DgroupId=com.xtreme.rest -DartifactId=xl-rest \
	-Dversion=2.0.4 -Dpackaging=jar -Dfile="/extras/xl-rest_lib-android-v2.0.4.jar"

echo "Installing Xtreme network library..."
mvn -q install:install-file -DgroupId=com.xtreme.network -DartifactId=xl-network \
	-Dversion=1.0 -Dpackaging=jar -Dfile="/extras/xtreme-network-v1.0.jar"

echo "Installing Xtreme threading library..."
mvn -q install:install-file -DgroupId=com.xtreme.threading -DartifactId=xl-threading \
	-Dversion=1.1.1 -Dpackaging=jar -Dfile="/extras/xl-threading_lib-android-v1.1.1.jar"

