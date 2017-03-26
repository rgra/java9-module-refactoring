rd /s/q vetapp
rd /s/q carapp
"C:\Program Files\Java\jdk-9\bin"\jlink --module-path "C:\Program Files\Java\jdk-9\jmods";mlib/vet --add-modules de.rgra.vet.app_05 --output vetapp --launcher vet=de.rgra.vet.app_05/de.rgra.vet.VetAppConfiguration --limit-modules de.rgra.app_05,de.rgra.model_05,de.rgra.pet_05,de.rgra.ui_05,java.base,javafx.base,javafx.controls,javafx.graphics --compress 2 --strip-debug  --no-header-files --no-man-pages
"C:\Program Files\Java\jdk-9\bin"\jlink --module-path "C:\Program Files\Java\jdk-9\jmods";mlib/car --add-modules de.rgra.car.app_05 --output carapp --launcher car=de.rgra.car.app_05/de.rgra.car.app.CarAppConfiguration  --compress 2 --strip-debug  --no-header-files --no-man-pages
vetapp/bin/vet.bat
