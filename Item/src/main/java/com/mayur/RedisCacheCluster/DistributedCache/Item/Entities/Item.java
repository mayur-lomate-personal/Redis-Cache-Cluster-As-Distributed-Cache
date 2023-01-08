package com.mayur.RedisCacheCluster.DistributedCache.Item.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item implements Serializable {

    @GeneratedValue
    @EqualsAndHashCode.Include
    @Id
    private Integer itemId;
    private String itemName;
}
