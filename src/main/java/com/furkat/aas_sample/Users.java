package com.furkat.aas_sample;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity // このクラスがDoma2のエンティティであることを示すアノテーション
@Table(name = "Users") // 対応するデータベースのテーブル名を指定
public class Users {

    @Id // このフィールドがテーブルの主キーであることを示すアノテーション
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーが自動で生成されることを示すアノテーション
    public Integer id; // ユーザのID

    public String name; // ユーザの名前

}
