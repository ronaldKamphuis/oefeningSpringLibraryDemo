package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class OefenOpdrachtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OefenOpdrachtApplication.class, args);
	}

}
