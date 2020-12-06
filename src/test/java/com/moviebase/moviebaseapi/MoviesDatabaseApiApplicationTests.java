package com.moviebase.moviebaseapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MoviesDatabaseApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void bcryptPasswordGenerator() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		System.out.println(encoder.encode("admin123"));
	}
}
