# Citronix

Citronix est une application backend développée en **Spring Boot** avec une intégration à **PostgreSQL**. Ce projet a pour but de [décrire brièvement la fonctionnalité principale de votre application, par exemple : gestion des utilisateurs, tableau de bord analytique, etc.].

## Table des Matières

1. [Fonctionnalités](#fonctionnalités)
2. [Prérequis](#prérequis)
3. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [Structure du Projet](#structure-du-projet)
6. [API Endpoints](#api-endpoints)
7. [Technologies Utilisées](#technologies-utilisées)
8. [Contributions](#contributions)
9. [Licence](#licence)
10. [Auteur](#auteur)

---

## Fonctionnalités

- Gestion CRUD (Créer, Lire, Mettre à jour, Supprimer) des entités.
- Authentification et autorisation via Spring Security (JWT).
- Intégration avec PostgreSQL pour le stockage des données.
- Pagination et tri des données dans les endpoints.
- API RESTful conforme aux bonnes pratiques.
- Tests unitaires avec JUnit.

---

## Prérequis

Avant de démarrer, vous devez avoir installé les éléments suivants :

- **Java 17** ou version ultérieure
- **Maven** (ou **Gradle**)
- **PostgreSQL** (avec un utilisateur et une base de données configurés)
- **Git**

---

## Installation

### Étape 1 : Cloner le dépôt

Clonez le projet sur votre machine locale :

```bash
git clone https://github.com/NabilElHakimi/citronix.git
cd citronix
