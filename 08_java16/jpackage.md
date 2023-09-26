# How to jpackage
## Preparation
- mvn package
- Erzeuge Ordnerstruktur: C:\tmp\input und C:\tmp\output
- Lege das java16-0.0.1.jar nach C:\tmp\input

## Run jpackage in Cmd (git bash)
jpackage --input "C:\tmp\input" --dest "C:\tmp\output" --name Example --main-jar java16-0.0.1.jar --main-class de.zettsystems.java16.pattern.PatternInstanceOf --type app-image --win-console

## Run Application
Doppelklick auf Example.exe

## Docs
https://docs.oracle.com/en/java/javase/17/docs/specs/man/jpackage.html
