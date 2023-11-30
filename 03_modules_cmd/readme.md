# Oldschool ausführen
java -cp "./modules/*" de.zettsystems.main.MainApp

# Als modul ausführen
## Long:
java --module-path modules --module de.zettsystems.main/de.zettsystems.main.MainApp
## Short:
java -p modules -m de.zettsystems.main/de.zettsystems.main.MainApp 

#Dependencies
jdeps -s --module-path ./modules ./modules/main-0.0.1.jar
## docs
https://docs.oracle.com/en/java/javase/11/tools/jdeps.html#GUID-A543FEBE-908A-49BF-996C-39499367ADB4

# Create Custome JRE
jlink --output ./customjre/ --module-path "C:\Program Files\Eclipse Adoptium\jdk-17.0.8.101-hotspot\jmods" --add-modules java.base
## Options
--strip-debug
--strip-native-commands (ohne .exe ...)
--compress 2
--no-header-files
--no-man-pages
## docs
https://docs.oracle.com/en/java/javase/11/tools/jlink.html#GUID-CECAC52B-CFEE-46CB-8166-F17A8E9280E9
# Create minimal JRE
jlink --strip-debug --compress 2 --no-header-files --no-man-pages --output ./mincustomjre/ --module-path "C:\Program Files\Eclipse Adoptium\jdk-17.0.8.101-hotspot\jmods" --add-modules java.base
# Vergleich
- jdk17 	: 299 MB
- jdk17-jre : 120 MB
- customjdk	:  45 MB
- minjdk	:  25 MB

# List Modules
./customjre/bin/java --list-modules
./mincustomjre/bin/java --list-modules
cd modul

# Use Custom Jre
./customjre/bin/java -p modules -m de.zettsystems.main/de.zettsystems.main.MainApp 
./mincustomjre/bin/java -p modules -m de.zettsystems.main/de.zettsystems.main.MainApp 

