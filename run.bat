@echo off
REM Créer le dossier bin si nécessaire
if not exist bin mkdir bin

REM Compiler et lancer
javac -d bin @compile.list && java -cp bin course.controleur.Controleur
