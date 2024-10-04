# Redis Cluster As Distributed Cache

The Redis-Cache-Cluster-As-Distributed-Cache project demonstrates the integration of Redis Cluster as a distributed caching solution in a Spring Boot application. By leveraging Redis, this project optimizes data retrieval and enhances application performance through fast, in-memory data storage. The Redis Cluster provides scalability and high availability, ensuring that cached data is efficiently managed across multiple nodes. This implementation showcases how to configure and utilize Redis Cluster in a Spring Boot environment for improved response times and reduced load on backend databases.

## Installation

```docker
docker compose up -d
```

## Redis

redis-cluster is only for creating cluster, after creation the container ends, but docker will try to restart, you can neglect it. We can check cluster has been created or not, by executing below commands

```docker
redis-cli

CLUSTER NODES

KEYS *
```

## System Design

![Screenshot](./System-Design/Redis-Distributed-Cache.png)

