package com.furkat.aas_sample;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// エンドポイント用
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication  // Spring Bootのメインクラスであることを示すアノテーション
@RestController          // REST APIを提供するクラスであることを示すアノテーション
@CrossOrigin(origins = "http://localhost:3000")  // CORS設定。localhost:3000からのアクセスを許可
public class AasSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AasSampleApplication.class, args);  // Spring Bootアプリケーションを起動
	}

	// finalを追加して変更不可とします
	private final UsersDao usersDao;

	// コンストラクタを追加して依存関係を注入します
	public AasSampleApplication(UsersDao usersDao) {
		this.usersDao = usersDao;  // DAOを注入
	}

	@Bean
	CommandLineRunner runner() {
		// アプリケーション起動時に実行されるメソッド
		return args -> Arrays.asList("spring", "spring boot", "spring cloud", "doma").forEach(s -> {
			Users r = new Users();
			r.name = s;
			usersDao.insert(r);  // データベースにユーザを追加
		});
	}

	@RequestMapping(path = "/")
	List<Users> all() {
		return usersDao.selectAll();  // 全てのユーザを取得して返す
	}

	// POSTメソッドを処理するためのエンドポイント
	@PostMapping(path = "/")
	public Users createUser(@RequestBody Users user) {
		usersDao.insert(user);  // 受け取ったユーザ情報をデータベースに追加
		return user;           // 追加したユーザ情報を返す
	}
}
