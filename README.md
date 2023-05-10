# Track-Verwaltung
Dies ist eine Spring-Boot-Anwendung zur Verwaltung von Lieblingsmusik, die CRUD-Operationen für eine Entität bietet und Daten in einer Datenbank persistiert. Die Anwendung besteht aus einer REST-Schnittstelle und einer Web-Benutzeroberfläche.

## Technologien
- Spring Boot
- MySQL
- Spring Data JPA
- Spring MVC
- React.js
- TypeScript

## REST API
Die REST-Schnittstelle bietet folgende Endpunkte an:

### /api/tracks
- GET /api/tracks - gibt alle Lieder zurück
- GET /api/tracks/{id} - gibt ein bestimmtes Lied zurück
- POST /api/tracks - erstellt ein neues Lied
- PUT /api/tracks/{id} - aktualisiert ein bestehendes Lied
- DELETE /api/tracks/{id} - löscht ein bestimmtes Lied

## Web-Benutzeroberfläche
Die Web-Benutzeroberfläche ist in React.js und TypeScript geschrieben und bietet eine minimalistische Oberfläche zur Verwaltung der Lieblingsmusik. Die Benutzeroberfläche unterstützt alle CRUD-Operationen für die erstellten Entitäten.

## Tests
Es wurden exemplarisch Modul- und Integrationstests erstellt.

![alt text](https://github.com/janvollmuth/musiclibrary/blob/main/Frontend/Screenshot.PNG)
