package com.mayur.RedisCacheCluster.DistributedCache.Item.Services;

import com.mayur.RedisCacheCluster.DistributedCache.Item.Entities.Item;
import com.mayur.RedisCacheCluster.DistributedCache.Item.Exceptions.ItemNotFoundException;
import com.mayur.RedisCacheCluster.DistributedCache.Item.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;


    @Override
    //we don't need to cache it will saving
    public Item saveItem(Item item) {
        itemRepository.saveAndFlush(item);
        return item;
    }

    @Override
    @Caching(
            evict = {@CacheEvict(value = "Item", key="#itemId")},
            put   = {@CachePut(value = "Item", key = "#itm.getUserId()")}
    )
    public Item updateItem(Item itm, Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item Not Found"));
        item.setItemName(itm.getItemName());
        return itemRepository.save(item);
    }

    @Override
    @CacheEvict(value="Item", key="#itemId")
    // @CacheEvict(value="Item", allEntries=true) //in case there are multiple records to delete
    public void deleteItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item Not Found"));
        itemRepository.delete(item);
    }

    @Override
    @Cacheable(value="Item", key="#itemId")
    public Item getOneItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item Not Found"));
        return item;
    }

    @Override
    @Cacheable(value="Item")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
