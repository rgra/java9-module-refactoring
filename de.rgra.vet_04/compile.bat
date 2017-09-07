rd /s/q mods
mkdir mods

:: Copy commons.lang jar
xcopy /s/Y "de.rgra.model_04/mods" "mods"

::Find Sources and compile
dir /s /B *.java | find "." > sources.txt
"%JAVA9%"\javac -p mods --module-source-path "./*/src" -d classes  @sources.txt

:: Copy resource files
for %%f in (de.rgra.model_04,de.rgra.ui_04,de.rgra.pet_04,de.rgra.vet.app_04)  do xcopy /s/Y "%%f/resources" "classes/%%f"

:: Run the Application
"%JAVA9%"\java -p mods;classes -m de.rgra.vet.app_04/de.rgra.vet.VetServicesApplication
