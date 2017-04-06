#!/bin/bash -e
rm -Rf out
rm -Rf modules

JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

# Compile
$JAVA9/javac -cp lib/* -d out -sourcepath src $(find . -name "*.java")
cp -r -n resources/. out

# Create Jar
$JAVA9/jar --create --file de.rgra.vet.jar -C out .

# Extract Libraries
cd out
$JAVA9/jar -xf ../lib/commons-lang-2.6.jar 
cd ..

# Create Fat Jar
$JAVA9/jar --create --file de.rgra.vet_fat.jar -C out .

# Create module-info
$JAVA9/jdeps --generate-module-info modules de.rgra.vet_fat.jar

# Run
$JAVA9/java -cp lib/*:out de.rgra.vet.VetServicesApplication
