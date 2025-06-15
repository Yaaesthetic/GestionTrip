# Système de Gestion de Parc Automobile

## Description du Projet

Ce projet consiste en un système de gestion de parc automobile développé pour optimiser la gestion des véhicules et des conducteurs au sein d'une entreprise[1]. L'application permet de planifier les voyages, automatiser les affectations des véhicules et conducteurs, et rationaliser les dépenses liées au parc automobile[1].

## Fonctionnalités Principales

### Module Affectation
- **Gestion des profils conducteurs** : Création et gestion des profils incluant les informations personnelles, compétences, expérience de conduite, formations et certifications[1]
- **Gestion de la flotte** : Suivi des véhicules avec leurs caractéristiques, disponibilité, documents obligatoires (carte grise, assurance, visite technique, vignette)[1]
- **Planification des voyages** : Enregistrement des voyages avec date, heure, destination, type de véhicule nécessaire[1]
- **Affectation intelligente** : Attribution automatique des conducteurs basée sur leur disponibilité, compétences et aptitudes[1]

### Module Consommation
- **Suivi de carburant** : Surveillance et gestion de la consommation de carburant par véhicule[1]
- **Bons de consommation** : Système de suivi détaillé avec informations sur les kilomètres, carburant utilisé, coûts[1]
- **Rapports analytiques** : Génération de rapports par véhicule, conducteur, trajet, et marque/modèle[1]
- **Analyse comportementale** : Identification des habitudes de conduite pour optimiser la consommation[1]

## Architecture et Bonnes Pratiques

Ce projet respecte les principes et patterns suivants, conformément aux exigences de développement :

### Principes et Patterns
- **Inversion de Dépendance (ID)** : Découplage des modules via l'abstraction
- **Inversion de Contrôle (IoC)** : Gestion des dépendances par le conteneur Spring
- **Principes SOLID** :
  - **S**ingle Responsibility Principle
  - **O**pen/Closed Principle  
  - **L**iskov Substitution Principle
  - **I**nterface Segregation Principle
  - **D**ependency Inversion Principle

### Design Patterns
- **Builder Pattern** : Construction d'objets complexes étape par étape
- **DTO (Data Transfer Object)** : Transfert de données entre couches applicatives

## Technologies Utilisées
- **Spring Boot** : Framework principal pour le développement de l'application Java
- **Java** : Langage de programmation principal

[1] docs/Cahier_des_Charges.txt
