rd /s/q mlib
rd /s/q mods
mkdir mlib
mkdir mlib\vet
mkdir mlib\car
mkdir mods

rd /s/q mods
mkdir mods

:: Copy commons.lang jar
xcopy /s/Y "de.rgra.model_05/mods" "mods"
xcopy /s/Y "de.rgra.model_05/mods" "mlib"

::Find Sources and compile
dir /s /B *.java | find "." > sources.txt
"%JAVA9%"\javac -p mods --module-source-path "./*/src" -d classes  @sources.txt

:: Copy resource files
for %%f in (de.rgra.model_05,de.rgra.ui_05,de.rgra.pet_05,de.rgra.car_05,de.rgra.app_05,de.rgra.vet.app_05,de.rgra.car.app_05)  do xcopy /s/Y "%%f/resources" "classes/%%f"

:: Create Jar files for common
for %%f in (de.rgra.model_05,de.rgra.ui_05,de.rgra.app_05)  do "%JAVA9%"\jar --create --file "mlib/%%f.jar" -C "classes/%%f" .
:: vet
for %%f in (de.rgra.pet_05,de.rgra.vet.app_05)  do "%JAVA9%"\jar --create --file "mlib/vet/%%f.jar" -C "classes/%%f" .
:: car
for %%f in (de.rgra.car_05,de.rgra.car.app_05)  do "%JAVA9%"\jar --create --file "mlib/car/%%f.jar" -C "classes/%%f" .

