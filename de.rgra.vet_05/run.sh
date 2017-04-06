JAVA9=${JAVA9:-/usr/lib/jvm/java-9-oracle/bin}
[ ! -d "$JAVA9" ] && echo "Please configure a JAVA9 env variable pointing to a Java9 JDK /bin directory" && exit 1

$JAVA9/java -p mods/car -m de.rgra.car.app_05/de.rgra.car.app.CarAppConfiguration
# $JAVA9/java -p mods/vet -m de.rgra.vet.app_05/de.rgra.vet.VetAppConfiguration

