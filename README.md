lab1:Ce projet utilise Spring Boot pour créer une application web simple en Java. L’annotation @SpringBootApplication configure automatiquement l’application, et @RestController permet de créer des endpoints HTTP. Le contrôleur expose plusieurs routes, dont une qui retourne un objet JSON (Greeting). L’application peut être exécutée via une IDE, Maven ou Gradle, et personnalisée (ex. port, bannière). Enfin, un fichier NOTES.md permet de documenter la compréhension des concepts utilisés.
lab2:Le projet crée une application web simple avec Spring Boot, utilisant @SpringBootApplication pour la configuration et @RestController pour les endpoints HTTP. Il expose des routes, dont une qui retourne un objet JSON (Greeting). L’application est personnalisable (port, bannière) et peut être exécutée via IDE, Maven ou Gradle.
lab3:Ce travail consiste à créer une application Spring Boot pour gérer les informations d'étudiants via une API REST. On définit une entité Student pour représenter les étudiants, puis on utilise Spring Data JPA pour interagir avec la base de données H2. Le service gère la logique métier, et le contrôleur expose des endpoints REST pour récupérer et ajouter des étudiants. L'application utilise également un fichier de configuration pour paramétrer la base de données H2 et permet des tests via des requêtes HTTP avec des outils comme Postman.
lab4:Understand Spring Data JPA: You'll learn how to interact with a database using JPA, an abstraction layer for database access.

Integrate PostgreSQL with Spring Boot: You'll configure your Spring Boot application to connect to a PostgreSQL database.

Create Entity Classes & Repositories: You’ll define entities (like Student) and repositories (using Spring Data JPA) for interacting with the database.

Implement CRUD Operations: You’ll implement Create, Read, Update, and Delete operations for managing student records.

Test Data Persistence: Using REST endpoints, you’ll test the persistence layer of the applicatio
lab5
: 1. Introduction to Caching
Purpose: Caching improves performance by storing frequently accessed data in a high-speed storage layer, reducing the time to fetch data from slower sources.

Benefits:

Faster data retrieval

Reduced database load

Lower latency and improved throughput

Cost-efficiency

Cache Hit vs. Cache Miss:

Cache Hit: Data is found in the cache.

Cache Miss: Data isn't in the cache, so it must be retrieved from the primary data source.

2. Introduction to Redis
Redis is an open-source, in-memory data structure store used as a cache, database, message broker, and stream processor.

Key Features:

In-memory storage for fast operations

Supports various data structures like strings, hashes, lists, sets, and more

Persistence options available

Pub/Sub messaging and high availability

Clustering and data sharding for scalability

Redis vs. Traditional Databases:

Redis is faster but stores smaller datasets due to its in-memory nature.

3. Spring Boot Cache Abstraction
Spring Boot provides a unified caching abstraction that integrates with various cache providers, including Redis.

Key Annotations:

@EnableCaching: Enables caching in Spring Boot.

@Cacheable: Caches the result of a method.

@CachePut: Updates the cache without affecting the method.

@CacheEvict: Removes data from the cache.

@Caching: Multiple cache operations can be applied to a method.

CacheManager: Manages cache instances.

4. Integrating Redis with Spring Boot
Setup:

Add the spring-data-redis dependency.

Configure Redis connection properties in application.properties.

Define a cache configuration class.

Add caching annotations to service methods.

Configuration Properties:

Redis host, port, password, and database can be set in application.properties.

Cache expiration (spring.cache.redis.time-to-live) and cache type (spring.cache.type=redis) should be configured.

5. Caching Strategies and Best Practices
Common Strategies:

Cache-Aside: Data is loaded from the database only when not present in the cache.

Write-Through: Data is written to both the cache and the database at the same time.

Write-Behind: Data is written to the cache and then asynchronously to the database.

Refresh-Ahead: Preemptively refresh cache entries before they expire.

Eviction Policies:

Time-based (TTL), LRU, LFU, FIFO.

Best Practices:

Cache expensive-to-compute or infrequently changing data.

Set meaningful cache keys and TTL values.

Implement cache invalidation strategies.

6. Cache Consistency Challenges
Consistency Patterns:

Read-Through, Write-Through, and Write-Behind ensure consistency between the cache and the database.

Cache Invalidation: Set expiration times or manually invalidate cache when data changes.

Cache Synchronization in Distributed Systems: Cache consistency in distributed environments is maintained through replication and consistent hashing.

7. Performance Monitoring and Optimization
Key Metrics:

Cache hit ratio, memory usage, cache throughput, and latency.

Troubleshooting: Common issues include high cache miss rates, excessive memory use, cache thrashing, and inconsistent data.

8. Quiz
A quiz is included to assess understanding of caching, Redis, and Spring Boot caching annotations. Some of the quiz questions and answers are:

Primary purpose of caching: To reduce latency and improve performance.

Redis feature for caching: In-memory storage.

Cache eviction policy that is NOT valid: MFU (Most Frequently Used).






