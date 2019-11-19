package com.cristi.cardatabase;

import com.cristi.cardatabase.domain.Car;
import com.cristi.cardatabase.domain.CarRepository;
import com.cristi.cardatabase.domain.Owner;
import com.cristi.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);


			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			carRepository.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			carRepository.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			carRepository.save(car);
		};
	}
}
