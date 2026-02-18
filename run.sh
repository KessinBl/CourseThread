#!/bin/bash

mkdir -p bin

javac -d bin @compile.list && java -cp bin course.controleur.Controleur