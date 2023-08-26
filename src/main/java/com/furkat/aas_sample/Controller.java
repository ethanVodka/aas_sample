package com.furkat.aas_sample;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST APIを提供するクラスであることを示すアノテーション
@CrossOrigin(origins = "http://localhost:3000") // CORS設定。localhost:3000からのアクセスを許可

public class Controller {
    // finalを追加して変更不可とします
    private final UsersDao usersDao;

    // コンストラクタを追加して依存関係を注入します
    public Controller(UsersDao usersDao) {
        this.usersDao = usersDao; // DAOを注入
    }

    @RequestMapping(path = "/")
    List<Users> all() {
        return usersDao.selectAll(); // 全てのユーザを取得して返す
    }

    // POSTメソッドを処理するためのエンドポイント
    @PostMapping(path = "/")
    public Users createUser(@RequestBody Users user) {
        usersDao.insert(user); // 受け取ったユーザ情報をデータベースに追加
        return user; // 追加したユーザ情報を返す
    }
}
