rd /s/q out
rd /s/q modules

:: Compile
dir /s /B *.java > sources.txt
%JAVA9%\javac -cp lib/* -d out -sourcepath src @sources.txt
xcopy /s/Y "resources" "out"

:: Create Jar
%JAVA9%\jar --create --file de.rgra.vet.jar -C out .

:: Extract Libraries
cd out
%JAVA9%\jar -xf ../lib/commons-lang-2.6.jar 
cd ..

:: Create Fat Jar
%JAVA9%\jar --create --file de.rgra.vet_fat.jar -C out .

:: Create module-info
%JAVA9%\jdeps --generate-module-info modules de.rgra.vet_fat.jar

:: run
%JAVA9%\java -cp lib/*;out de.rgra.vet.VetServicesApplication
