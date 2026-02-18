# Course de Threads en Java
---

## I. Description

Simulation graphique d’une course entre threads pour observer le comportement indéterministe.

- Chaque coureur est un thread indépendant.

- Les rangs finaux dépendent de l’ordre d’exécution des threads.

- Possibilité de lancer et relancer plusieurs fois la course.
## II. Arborescence 

	C:.
	└───course
		├───controleur
		│       Controleur.java
		│
		├───modele
		│   │   Metier.java
		│   │
		│   └───entite
		│           Candidat.java
		│
		└───vue
			│   FrameCourse.java
			│   PanelCourse.java
			│
			└───terrainCourse
					Candidat.java
					PanelTerrainCourse.java
## III. Aperçu

- Carrés colorés représentant chaque coureur  
- Mise à jour graphique en temps réel  
- Rang final affiché au centre du carré 

### video demonstrative

![Course des threads](assets/course.gif)

## IV. Comment lancer le projet

### 1. sur linux 

Après avoir récupérer le projet , placer vous a la racine du projet et lancer le la commande : 

	./run.sh

### 2. sur Windows 

Après avoir récupérer le projet , placer vous a la racine du projet et lancer le la commande : 

	./run.bat

ou rendez-vous à la racine du projet dans l'explorateur de fichier et double-cliquez sur run.bat.

## V. Technologie

- Java 8+

- Swing (GUI)

- MVC (Modèle-Vue-Contrôleur)

- Threads (Runnable)