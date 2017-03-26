mkdir mlib
cd mlib
mkdir vet
mkdir car
cd ..
mkdir mods

cd de.rgra.model_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/vet -d mods/vet/de.rgra.model_05 @sources.txt
xcopy /s/Y "de.rgra.model_05/resources" "mods/vet/de.rgra.model_05"
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/car -d mods/car/de.rgra.model_05 @sources.txt
xcopy /s/Y "de.rgra.model_05/resources" "mods/car/de.rgra.model_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file mlib/vet/de.rgra.model.jar -C mods/vet/de.rgra.model_05 .
"C:\Program Files\Java\jdk-9\bin"\jar --create --file mlib/car/de.rgra.model.jar -C mods/car/de.rgra.model_05 .

cd de.rgra.ui_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/vet -d mods/vet/de.rgra.ui_05 @sources.txt
xcopy /s/Y "de.rgra.ui_05/resources" "mods/vet/de.rgra.ui_05"
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/car -d mods/car/de.rgra.ui_05 @sources.txt
xcopy /s/Y "de.rgra.ui_05/resources" "mods/car/de.rgra.ui_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/vet/de.rgra.ui.jar -C mods/vet/de.rgra.ui_05 .
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/car/de.rgra.ui.jar -C mods/car/de.rgra.ui_05 .

cd de.rgra.car_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/car -d mods/car/de.rgra.car_05 @sources.txt
xcopy /s/Y "de.rgra.car_05/resource" "mods/car/de.rgra.car_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/car/de.rgra.car.jar -C mods/car/de.rgra.car_05 .

cd de.rgra.pet_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/vet -d mods/vet/de.rgra.pet_05 @sources.txt
xcopy /s/Y "de.rgra.pet_05/resource" "mods/vet/de.rgra.pet_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/vet/de.rgra.pet.jar -C mods/vet/de.rgra.pet_05 .

cd de.rgra.app_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/vet -d mods/vet/de.rgra.app_05 @sources.txt
xcopy /s/Y "de.rgra.app_05/resource" "mods/vet/de.rgra.app_05"
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/car -d mods/car/de.rgra.app_05 @sources.txt
xcopy /s/Y "de.rgra.app_05/resource" "mods/car/de.rgra.app_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/vet/de.rgra.app.jar -C mods/vet/de.rgra.app_05 .
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/car/de.rgra.app.jar -C mods/car/de.rgra.app_05 .

cd de.rgra.car.app_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --module-path mods/car -d mods/car/de.rgra.car.app_05 @sources.txt
xcopy /s/Y "de.rgra.car.app_05/resource" "mods/car/de.rgra.car.app_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/car/de.rgra.car.app.jar -C mods/car/de.rgra.car.app_05 .

cd de.rgra.vet.app_05
dir /s /B *.java > ..\sources.txt
cd ..
"C:\Program Files\Java\jdk-9\bin"\javac --limit-modules de.rgra.app_05,de.rgra.model_05,de.rgra.pet_05,de.rgra.ui_05,java.base,javafx.base,javafx.controls,javafx.graphics --module-path mods/vet -d mods/vet/de.rgra.vet.app_05 @sources.txt
xcopy /s/Y "de.rgra.vet.app_05/resource" "mods/vet/de.rgra.vet.app_05"
"C:\Program Files\Java\jdk-9\bin"\jar --create --file=mlib/vet/de.rgra.vet.app.jar -C mods/vet/de.rgra.vet.app_05 .

