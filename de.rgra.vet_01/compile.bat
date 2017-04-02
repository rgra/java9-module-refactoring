rd /s/q out

:: Compile
dir /s /B *.java > sources.txt
%JAVA9%\javac -cp lib/* -d out -sourcepath src @sources.txt
xcopy /s/Y "resources" "out"

:: run
%JAVA9%\java -cp lib/*;out de.rgra.vet.VetServicesApplication
