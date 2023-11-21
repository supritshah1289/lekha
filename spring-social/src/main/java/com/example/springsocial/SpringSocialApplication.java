package com.example.springsocial;

import com.example.springsocial.config.AppProperties;
import com.example.springsocial.model.Address;
import com.example.springsocial.model.Item;
import com.example.springsocial.model.User;
import com.example.springsocial.repository.AddressRepository;
import com.example.springsocial.repository.CategoryRepository;
import com.example.springsocial.repository.ItemRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSocialApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ItemRepository itemRepository;
/*

	@Override
	public void run(String... args) throws Exception {


		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		Point point = geometryFactory.createPoint(new Coordinate(40.6976312,-74.1444869));

		Address address = new Address();
		address.setStreet("1 Central Park S");
		address.setCity("New York");
		address.setUserId(1L);
		address.setGeolocation(point);
		address.setState("New York");
		address.setCountry("USA");
		address.setZipCode("10019");
		address.setCreatedAt(new Date(2023, 10,15));
		addressRepository.save(address);

		List<Address> address1 = addressRepository.findAll();
		System.out.println(address1.toString());

	}

*/


}
