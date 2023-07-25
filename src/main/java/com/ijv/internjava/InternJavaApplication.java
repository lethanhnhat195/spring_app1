package com.ijv.internjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

@SpringBootApplication
public class InternJavaApplication {
	public static void main(String[]  args) {
		SpringApplication.run(InternJavaApplication.class, args);
	}
}
