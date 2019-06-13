package com.tripData;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tripData.Repository.PlaceRepository;
import com.tripData.Repository.PlaceRepositoryImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PlaceDataApplication {

	@Bean
	public PlaceRepository getRepoo() {
		MysqlDataSource source = new MysqlDataSource();
		source.setURL("jdbc:mysql://localhost:3306/trip_data?user=root");
		return new PlaceRepositoryImp(source);
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaceDataApplication.class, args);
	}

}
