# Utilisation d'une image Java de base
FROM openjdk:latest

# Créer un répertoire de travail dans l'image Docker
WORKDIR /app

# Copier le fichier WAR généré par Maven dans l'image Docker
COPY target/*.war /app/mon_projet.war

# Commande d'exécution pour démarrer l'application Java
CMD ["java", "-jar", "mon_projet.war"]
