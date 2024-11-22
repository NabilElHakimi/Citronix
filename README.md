# Citronix

**Citronix** est une application de gestion développée en **Java Spring Boot** avec une base de données **PostgreSQL**. L'objectif principal est de fournir un outil aux fermiers pour gérer leurs fermes de citrons, en optimisant la production, la récolte, et la vente tout en respectant des contraintes spécifiques.

---

## Table des Matières

1. [Contexte du Projet](#contexte-du-projet)
2. [Fonctionnalités Principales](#fonctionnalités-principales)
3. [Contraintes](#contraintes)
4. [Exigences Techniques](#exigences-techniques)
5. [Installation et Configuration](#installation-et-configuration)
6. [Endpoints API](#endpoints-api)
7. [Structure du Projet](#structure-du-projet)
8. [Diagramme UML](#diagramme-uml)
9. [Technologies Utilisées](#technologies-utilisées)
10. [Contributions](#contributions)
11. [Licence](#licence)
12. [Auteur](#auteur)

---

## Contexte du Projet

Le projet **Citronix** vise à aider les fermiers de citrons à :

- Suivre la production de leurs arbres.
- Gérer leurs champs, fermes et récoltes.
- Calculer la productivité annuelle des arbres en fonction de leur âge.
- Enregistrer et suivre les ventes.

Cette application offre une interface RESTful permettant une intégration facile avec des applications front-end ou des systèmes tiers.

---

## Fonctionnalités Principales

### Gestion des Fermes
- **Créer, modifier, supprimer et consulter** les informations d'une ferme.
- **Recherche multicritère** des fermes (nom, localisation, superficie, date de création).

### Gestion des Champs
- **Associer des champs** à une ferme avec des contraintes sur la superficie.
- La somme des superficies des champs d'une ferme doit être strictement inférieure à celle de la ferme.

### Gestion des Arbres
- Suivre les arbres avec leur date de plantation, âge, et champ d'appartenance.
- Calculer la **productivité annuelle** des arbres en fonction de leur âge.

### Gestion des Récoltes
- Enregistrer une seule récolte par saison (hiver, printemps, été, automne).
- Associer les quantités récoltées à chaque arbre.

### Gestion des Ventes
- Enregistrer les ventes (date, prix unitaire, client, récolte associée).
- Calculer le revenu total : **Revenu = quantité x prix unitaire**.

---

## Contraintes

- Superficie minimale des champs : **0,1 hectare** (1 000 m²).
- Superficie maximale des champs : **50%** de la superficie totale de la ferme.
- **Nombre maximal de champs** par ferme : 10.
- Densité maximale : **100 arbres par hectare** (10 arbres / 1 000 m²).
- Durée de vie maximale des arbres : **20 ans**.
- Période de plantation : **mars à mai**.
- Une récolte par champ et par saison.

---

## Exigences Techniques

- **Framework Backend :** Spring Boot.
- **Base de Données :** PostgreSQL.
- Architecture en couches (Controller, Service, Repository, Entity).
- Validation des données avec les annotations Spring.
- Gestion centralisée des exceptions.
- Tests unitaires avec JUnit et Mockito.
- Conversion des entités vers des DTOs via **MapStruct**.
- Documentation des APIs avec **Swagger**.

---

## Installation et Configuration

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/NabilElHakimi/citronix.git
   cd citronix
