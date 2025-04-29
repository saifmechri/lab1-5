# Notes de compréhension - Hello World Spring Boot

## 1. Annotations utilisées
- @SpringBootApplication : Active auto-configuration, scan de composants et configuration
- @RestController : Déclare un contrôleur REST
- @GetMapping : Gère les requêtes GET
- @RequestParam : Lit les paramètres dans l’URL

## 2. Conversion en JSON
Spring Boot utilise Jackson pour convertir automatiquement les objets Java (POJO) en JSON

## 3. @SpringBootApplication
Combinaison de 3 annotations :
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan

## 4. Changer le port
Modifier le fichier `application.properties` :
```properties
server.port=8081
