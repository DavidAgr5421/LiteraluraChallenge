package com.literalura.challenge;

import com.literalura.challenge.principal.PrincipalMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalMenu menu = new PrincipalMenu();
		menu.showMenu();
	}
}
