package com.furkat.aas_sample;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

@ConfigAutowireable // Spring Bootの設定でDoma2のDaoを自動的に有効化するアノテーション
@Dao // このインターフェースがDoma2のDaoであることを示すアノテーション
public interface UsersDao {

    @Select // このメソッドがSELECT文を表すことを示すアノテーション
    List<Users> selectAll(); // すべてのユーザを取得するメソッド

    @Insert // このメソッドがINSERT文を表すことを示すアノテーション
    @Transactional // このメソッドをトランザクション内で実行することを示すアノテーション
    int insert(Users users); // ユーザ情報をデータベースに追加するメソッド

}
