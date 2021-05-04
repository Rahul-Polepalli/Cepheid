package com.cepheid.cloud.skel.service;
import java.util.Collection;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Collection<Item> getItemsByName(String name) {
		return itemRepository.findByName(name);
	}
	
	public Collection<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
