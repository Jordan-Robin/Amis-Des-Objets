package com.eni.amis.des.objets;

import com.eni.amis.des.objets.exceptions.BusinessCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(BusinessCode.FRAG_HEADER_A_ACCUEIL);
	}

}
