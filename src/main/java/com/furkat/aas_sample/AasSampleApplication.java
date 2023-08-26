package com.furkat.aas_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Bootのメインクラスであることを示すアノテーション
public class AasSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AasSampleApplication.class, args); // Spring Bootアプリケーションを起動
	}
}
