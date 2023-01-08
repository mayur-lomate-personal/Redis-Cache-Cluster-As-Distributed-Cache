package com.mayur.RedisCacheCluster.DistributedCache.Item.Services;

import com.mayur.RedisCacheCluster.DistributedCache.Item.Entities.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(Item item);
    public Item updateItem(Item item, Integer itemId);
    public void deleteItem(Integer itemId);
    public Item getOneItem(Integer itemId);
    public List<Item> getAllItems();
}
