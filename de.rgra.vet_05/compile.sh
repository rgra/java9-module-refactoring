#!/bin/bash -e
rm -Rf mods
rm -Rf mlib
mkdir mlib
mkdir mlib/vet
mkdir mlib/car
mkdir mods

JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

MODULE=de.rgra.model_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p $MODULE/mods -d mods/vet/$MODULE $SOURCES
$JAVA9/javac -p $MODULE/mods -d mods/car/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/vet/$MODULE
cp -r -n $MODULE/resources/. mods/car/$MODULE
cp -r -n $MODULE/mods/. mods/vet
cp -r -n $MODULE/mods/. mods/car
cp -r -n $MODULE/mods/. mlib/vet
cp -r -n $MODULE/mods/. mlib/car
$JAVA9/jar --create --file mlib/vet/de.rgra.model.jar -C mods/vet/$MODULE .
$JAVA9/jar --create --file mlib/car/de.rgra.model.jar -C mods/car/$MODULE .


MODULE=de.rgra.ui_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/vet -d mods/vet/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/vet/$MODULE
$JAVA9/javac -p mods/car -d mods/car/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/car/$MODULE
$JAVA9/jar --create --file=mlib/vet/de.rgra.ui.jar -C mods/vet/$MODULE .
$JAVA9/jar --create --file=mlib/car/de.rgra.ui.jar -C mods/car/$MODULE .

MODULE=de.rgra.car_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/car -d mods/car/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/car/$MODULE
$JAVA9/jar --create --file=mlib/car/de.rgra.car.jar -C mods/car/$MODULE .

MODULE=de.rgra.pet_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/vet -d mods/vet/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/vet/$MODULE
$JAVA9/jar --create --file=mlib/vet/de.rgra.pet.jar -C mods/vet/$MODULE .


MODULE=de.rgra.app_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/vet -d mods/vet/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/vet/$MODULE
$JAVA9/javac -p mods/car -d mods/car/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/car/$MODULE
$JAVA9/jar --create --file=mlib/vet/de.rgra.app.jar -C mods/vet/$MODULE .
$JAVA9/jar --create --file=mlib/car/de.rgra.app.jar -C mods/car/$MODULE .


MODULE=de.rgra.car.app_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/car -d mods/car/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/car/$MODULE
$JAVA9/jar --create --file=mlib/car/de.rgra.car.app.jar -C mods/car/$MODULE .

MODULE=de.rgra.vet.app_05
SOURCES=$(find . -path "*/$MODULE/*.java")
$JAVA9/javac -p mods/vet -d mods/vet/$MODULE $SOURCES
cp -r -n $MODULE/resources/. mods/vet/$MODULE
$JAVA9/jar --create --file=mlib/vet/de.rgra.vet.app.jar -C mods/vet/$MODULE .
