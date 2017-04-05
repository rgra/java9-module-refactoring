#!/bin/bash -e

rm -Rf vetapp
rm -Rf carapp
rm -Rf out

JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

# Create module-info
# $JAVA9/jdeps --generate-module-info modules mlib/vet/commons-lang-2.6.jar
# exports .enum not allowed.

# Patch commons-lang with module info, because only named modules are allowed for jlink
mkdir out
cd out
$JAVA9/jar -xf ../mlib/vet/commons-lang-2.6.jar
cd ..
$JAVA9/javac -cp mlib/vet/commons-lang-2.6.jar -d out modules/commons.lang/module-info.java
$JAVA9/jar uf mlib/vet/commons-lang-2.6.jar -C out module-info.class
$JAVA9/jar uf mlib/car/commons-lang-2.6.jar -C out module-info.class

$JAVA9/jlink --module-path "$JAVA9/../jmods":mlib/vet --add-modules de.rgra.vet.app_05 --output vetapp --launcher vet=de.rgra.vet.app_05/de.rgra.vet.VetAppConfiguration --limit-modules de.rgra.app_05,de.rgra.model_05,de.rgra.pet_05,de.rgra.ui_05,commons.lang,java.base,javafx.base,javafx.controls,javafx.graphics --compress 2 --strip-debug  --no-header-files --no-man-pages
$JAVA9/jlink --module-path "$JAVA9/../jmods":mlib/car --add-modules de.rgra.car.app_05 --output carapp --launcher car=de.rgra.car.app_05/de.rgra.car.app.CarAppConfiguration  --compress 2 --strip-debug  --no-header-files --no-man-pages
vetapp/bin/vet

