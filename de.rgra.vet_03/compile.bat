rd /s/q mods
mkdir mods

:: Copy commons.lang jar
xcopy /s/Y "de.rgra.model_03/mods" "mods"

::Find Sources and compile
dir /s /B *.java | find "." > sources.txt
"%JAVA9%"\javac -p mods --module-source-path "./*/src" -d classes  @sources.txt

:: Copy resource files
for %%f in (de.rgra.model_03,de.rgra.ui_03,de.rgra.pet_03,de.rgra.vet.app_03)  do xcopy /s/Y "%%f/resources" "classes/%%f"

:: Run the Application
"%JAVA9%"\java -p mods;classes -m de.rgra.vet.app_03/de.rgra.vet.VetServicesApplication
