package org.sid.customerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
}

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer, Long> {

}

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer(null, "ONEE", "onee@gmail.com"));
			customerRepository.save(new Customer(null, "CDM", "cdm@gmail.com"));
			customerRepository.save(new Customer(null, "Dell", "dell@gmail.com"));
			customerRepository.save(new Customer(null, "GOV", "gov@gmail.com"));
			customerRepository.save(new Customer(null, "BMCE", "bmce@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
