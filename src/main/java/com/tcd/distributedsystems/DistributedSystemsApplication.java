package com.tcd.distributedsystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedSystemsApplication {

	public static void main(String[] args) throws Exception {
		AccessingDataMongodbApplication application = SpringApplication.run(DistributedSystemsApplication.class, args)
				.getBean(AccessingDataMongodbApplication.class);
		application.run();

	}

}
