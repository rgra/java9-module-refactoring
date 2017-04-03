dir /s /B *.java > sources.txt

mkdir mods
%JAVA9%\javac -source 1.8 -target 1.8 -p mods -d mods @sources.txt 
xcopy /Y ".\src\de\rgra\nl\*.properties" ".\mods\de\rgra\nl"
%JAVA9%\java -p mods -m resourcebundle/de.rgra.nl.Messages

mkdir out
javac -d out src/de/rgra/nl/Messages.java
xcopy /Y ".\src\de\rgra\nl\*.properties" ".\out\de\rgra\nl"
java -cp out de.rgra.nl.Messages