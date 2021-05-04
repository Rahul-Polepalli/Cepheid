package com.cepheid.cloud.skel;

import java.util.*;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cepheid.cloud.skel.controller.ItemController;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;

import com.cepheid.cloud.skel.model.Description;

@SpringBootApplication(scanBasePackageClasses = { ItemController.class, SkelApplication.class })
@EnableJpaRepositories(basePackageClasses = { ItemRepository.class })
public class SkelApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkelApplication.class, args);
  }

  @Bean
  ApplicationRunner initItems(ItemRepository repository) {
	  Item item = new Item(1L, "Iphone", "KA");
	  List<Description> descriptionList = new ArrayList<>();
	  Description description = new Description(1L, "Indian Model");
	  descriptionList.add(description);
	  item.setDescriptions(descriptionList);
	  repository.save(item);
    return args -> {
      repository.findAll().forEach(System.out::println);
    };
  }

}
