rd /s/q mods
mkdir mods

dir /s /B *.java | find "de.rgra.model_04" > sources.txt
%JAVA9%\javac -p de.rgra.model_04/mods -d mods/de.rgra.model_04 @sources.txt
xcopy /s/Y "de.rgra.model_04/resources" "mods/de.rgra.model_04"
xcopy /s/Y "de.rgra.model_04/mods" "mods"

dir /s /B *.java | find "de.rgra.ui_04" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.ui_04 @sources.txt
xcopy /s/Y "de.rgra.ui_04/resources" "mods/de.rgra.ui_04"

dir /s /B *.java | find "de.rgra.pet_04" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.pet_04 @sources.txt
xcopy /s/Y "de.rgra.pet_04/resources" "mods/de.rgra.pet_04"

dir /s /B *.java | find "de.rgra.vet.app_04" > sources.txt
%JAVA9%\javac --module-path mods/ -d mods/de.rgra.vet.app_04 @sources.txt
xcopy /s/Y "de.rgra.vet.app_04/resources" "mods/de.rgra.vet.app_04"

%JAVA9%\java -p mods -m de.rgra.vet.app_04/de.rgra.vet.VetServicesApplication
