rd /s/q mlib
rd /s/q mods
mkdir mlib
mkdir mlib\vet
mkdir mlib\car
mkdir mods

dir /s /B *.java | find "de.rgra.model_05" > sources.txt
%JAVA9%\javac -p de.rgra.model_05/mods -d mods/vet/de.rgra.model_05 @sources.txt
%JAVA9%\javac -p de.rgra.model_05/mods -d mods/car/de.rgra.model_05 @sources.txt
xcopy /s/Y "de.rgra.model_05/resources" "mods/vet/de.rgra.model_05"
xcopy /s/Y "de.rgra.model_05/resources" "mods/car/de.rgra.model_05"
xcopy /s/Y "de.rgra.model_05/mods" "mods/vet"
xcopy /s/Y "de.rgra.model_05/mods" "mods/car"
xcopy /s/Y "de.rgra.model_05/mods" "mlib/vet"
xcopy /s/Y "de.rgra.model_05/mods" "mlib/car"
%JAVA9%\jar --create --file mlib/vet/de.rgra.model.jar -C mods/vet/de.rgra.model_05 .
%JAVA9%\jar --create --file mlib/car/de.rgra.model.jar -C mods/car/de.rgra.model_05 .

dir /s /B *.java | find "de.rgra.ui_05" > sources.txt
%JAVA9%\javac -p mods/vet -d mods/vet/de.rgra.ui_05 @sources.txt
xcopy /s/Y "de.rgra.ui_05/resources" "mods/vet/de.rgra.ui_05"
%JAVA9%\javac -p mods/car -d mods/car/de.rgra.ui_05 @sources.txt
xcopy /s/Y "de.rgra.ui_05/resources" "mods/car/de.rgra.ui_05"
%JAVA9%\jar --create --file=mlib/vet/de.rgra.ui.jar -C mods/vet/de.rgra.ui_05 .
%JAVA9%\jar --create --file=mlib/car/de.rgra.ui.jar -C mods/car/de.rgra.ui_05 .

dir /s /B *.java | find "de.rgra.car_05" > sources.txt
%JAVA9%\javac -p mods/car -d mods/car/de.rgra.car_05 @sources.txt
xcopy /s/Y "de.rgra.car_05/resources" "mods/car/de.rgra.car_05"
%JAVA9%\jar --create --file=mlib/car/de.rgra.car.jar -C mods/car/de.rgra.car_05 .

dir /s /B *.java | find "de.rgra.pet_05" > sources.txt
%JAVA9%\javac -p mods/vet -d mods/vet/de.rgra.pet_05 @sources.txt
xcopy /s/Y "de.rgra.pet_05/resources" "mods/vet/de.rgra.pet_05"
%JAVA9%\jar --create --file=mlib/vet/de.rgra.pet.jar -C mods/vet/de.rgra.pet_05 .

dir /s /B *.java | find "de.rgra.app_05" > sources.txt
%JAVA9%\javac -p mods/vet -d mods/vet/de.rgra.app_05 @sources.txt
xcopy /s/Y "de.rgra.app_05/resources" "mods/vet/de.rgra.app_05"
%JAVA9%\javac -p mods/car -d mods/car/de.rgra.app_05 @sources.txt
xcopy /s/Y "de.rgra.app_05/resources" "mods/car/de.rgra.app_05"
%JAVA9%\jar --create --file=mlib/vet/de.rgra.app.jar -C mods/vet/de.rgra.app_05 .
%JAVA9%\jar --create --file=mlib/car/de.rgra.app.jar -C mods/car/de.rgra.app_05 .

dir /s /B *.java | find "de.rgra.car.app_05" > sources.txt
%JAVA9%\javac -p mods/car -d mods/car/de.rgra.car.app_05 @sources.txt
xcopy /s/Y "de.rgra.car.app_05/resources" "mods/car/de.rgra.car.app_05"
%JAVA9%\jar --create --file=mlib/car/de.rgra.car.app.jar -C mods/car/de.rgra.car.app_05 .

dir /s /B *.java | find "de.rgra.vet.app_05" > sources.txt
%JAVA9%\javac -p mods/vet -d mods/vet/de.rgra.vet.app_05 @sources.txt
xcopy /s/Y "de.rgra.vet.app_05/resources" "mods/vet/de.rgra.vet.app_05"
%JAVA9%\jar --create --file=mlib/vet/de.rgra.vet.app.jar -C mods/vet/de.rgra.vet.app_05 .

