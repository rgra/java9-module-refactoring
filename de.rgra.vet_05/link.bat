rd /s/q vetapp
rd /s/q carapp
rd /s/q out

:: Create module-info
:: %JAVA9%\jdeps --generate-module-info modules mlib/commons-lang3-3.6.jar
:: exports .enum not allowed.

:: Patch commons-lang with module info, because only named modules are allowed for jlink
mkdir out
cd out
"%JAVA9%"\jar -xf ../mlib/commons-lang3-3.6.jar
cd ..
"%JAVA9%"\javac -cp mlib/commons-lang3-3.6.jar -d out modules\commons.lang\module-info.java
"%JAVA9%"\jar --create --file "mlib/commons-lang3-3.6.jar" -C out .

:: Link our modules and jdk modules and create a runnable application
"%JAVA9%"\jlink --module-path "%JAVA9%\..\jmods";mlib;mlib/vet --add-modules de.rgra.vet.app_05 --output vetapp --launcher vet=de.rgra.vet.app_05/de.rgra.vet.VetAppConfiguration --limit-modules de.rgra.app_05,de.rgra.model_05,de.rgra.pet_05,de.rgra.ui_05,org.apache.commons.lang3,java.base,javafx.base,javafx.controls,javafx.graphics --compress 2 --strip-debug  --no-header-files --no-man-pages
"%JAVA9%"\jlink --module-path "%JAVA9%\..\jmods";mlib;mlib/car --add-modules de.rgra.car.app_05 --output carapp --launcher car=de.rgra.car.app_05/de.rgra.car.app.CarAppConfiguration  --compress 2 --strip-debug  --no-header-files --no-man-pages

:: Launch the vet application with native launcher
vetapp/bin/vet.bat

