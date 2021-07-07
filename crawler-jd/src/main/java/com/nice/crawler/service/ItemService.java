package com.nice.crawler.service;

import com.nice.crawler.pojo.Item;

import java.util.List;

public interface ItemService {
    /**
     * 保存商品
     * @param item
     * @return
     */
    Item save(Item item);

    /**
     * 根据条件查询商品
     * @param item
     * @return
     */
    List<Item> findAll(Item item);
}
