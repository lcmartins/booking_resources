package com.example.booking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class BookingApplication {


	@Value("${settings.timezone}")
	private String applicationTimeZone;

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone(applicationTimeZone));
	}
}
