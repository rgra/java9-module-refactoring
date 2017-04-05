#!/bin/bash -e
rm -Rf out

JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

# Compile
$JAVA9/javac -cp lib/* -d out -sourcepath src $(find . -name "*.java")
cp -r -n resources/. out

# Run
$JAVA9/java -cp lib/*:out de.rgra.vet.VetServicesApplication
