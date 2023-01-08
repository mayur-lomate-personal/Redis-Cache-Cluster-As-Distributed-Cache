package com.mayur.RedisCacheCluster.DistributedCache.Item.Repositories;

import com.mayur.RedisCacheCluster.DistributedCache.Item.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
