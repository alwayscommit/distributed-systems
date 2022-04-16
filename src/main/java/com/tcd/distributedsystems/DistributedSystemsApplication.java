package com.tcd.distributedsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedSystemsApplication.class, args);

		// Chaos Testing: Generate a failure between 15-25s after server start
		// int RandomFailTime = 15000 + (int) (Math.random() * 10000);
		// try {
		// Thread.sleep(RandomFailTime);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.exit(0);
	}

}
