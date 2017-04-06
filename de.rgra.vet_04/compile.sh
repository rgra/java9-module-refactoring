#!/bin/bash -e
rm -Rf mods
mkdir mods

JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

MODULE=de.rgra.model_04
$JAVA9/javac -p $MODULE/mods -d mods/$MODULE $(find . -path "*/$MODULE/*.java")
cp -r -n $MODULE/resources/. mods/$MODULE
cp -r -n $MODULE/mods/. mods

for module in "de.rgra.ui_04" "de.rgra.pet_04" "de.rgra.vet.app_04"
do
$JAVA9/javac --module-path mods/ -d mods/$module $(find . -path "*/$module/*.java")
cp -r -n $module/resources/. mods/$module
done

# Run
$JAVA9/java -p mods -m de.rgra.vet.app_04/de.rgra.vet.VetServicesApplication
