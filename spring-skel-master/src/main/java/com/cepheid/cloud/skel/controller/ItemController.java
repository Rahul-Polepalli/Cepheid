package com.cepheid.cloud.skel.controller;

import java.util.Collection;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;
import com.cepheid.cloud.skel.service.ItemService;

import io.swagger.annotations.Api;
// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

	private final ItemRepository mItemRepository;
	
	@Autowired
	private ItemService itemService;

	@Autowired
	public ItemController(ItemRepository itemRepository) {
		mItemRepository = itemRepository;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Collection<Item> getItems() {
		return itemService.getAllItems();
	}

	@GET
	@Path("/byName")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Collection<Item> getItemsByName(@QueryParam("name") String name) {
		return itemService.getItemsByName(name);
	}

}
