rd /s/q mods
mkdir mods

dir /s /B *.java | find "de.rgra.model_03" > sources.txt
%JAVA9%\javac -p de.rgra.model_03/mods -d mods/de.rgra.model_03 @sources.txt
xcopy /s/Y "de.rgra.model_03/resources" "mods/de.rgra.model_03"
xcopy /s/Y "de.rgra.model_03/mods" "mods"

dir /s /B *.java | find "de.rgra.ui_03" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.ui_03 @sources.txt
xcopy /s/Y "de.rgra.ui_03/resources" "mods/de.rgra.ui_03"

dir /s /B *.java | find "de.rgra.pet_03" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.pet_03 @sources.txt
xcopy /s/Y "de.rgra.pet_03/resources" "mods/de.rgra.pet_03"

dir /s /B *.java | find "de.rgra.vet.app_03" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.vet.app_03 @sources.txt
xcopy /s/Y "de.rgra.vet.app_03/resources" "mods/de.rgra.vet.app_03"

%JAVA9%\java -p mods -m de.rgra.vet.app_03/de.rgra.vet.VetServicesApplication
