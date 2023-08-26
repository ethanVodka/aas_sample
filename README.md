# aas_sample

### 1 - 参考サイト
- https://ik.am/entries/371
- https://intellectual-curiosity.tokyo/2019/04/21/spring-boot%E3%81%A7%E3%83%87%E3%83%BC%E3%82%BF%E3%83%99%E3%83%BC%E3%82%B9%E3%81%AB%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95/
- https://github.com/domaframework/doma-spring-boot
- https://qiita.com/shukawam/items/ca3db198926b1b484c15
- https://www.tabnine.com/code/java/packages/org.seasar.doma.boot
- https://spring.pleiades.io/guides/tutorials/react-and-spring-data-rest/
- https://bufferings.hatenablog.com/entry/2016/12/10/093044
- __.....などなど__

### 2 - 苦労したところ
- React と java でデータのやり取りを行う部分
- __Spring-Boot と posgreSQL を Doma2 でアクセスし、データの追加、表示する部分__

```
Description:
Field reservationDao in com.furkat.aas_sample.AasSampleApplication required a bean of type 'com.furkat.aas_sample.UsersDao' that could not be found.

The injection point has the following annotations:
        - @org.springframework.beans.factory.annotation.Autowired(required=true)

Action:
Consider defining a bean of type 'com.furkat.aas_sample.UsersDao' in your configuration.
```
特に実行時のエラーを回避できなくてかなり苦労した。
原因としては UsersDao がパッケージに入っていない認定されてしまっていたためだった。
@Autowiredのアノテーション部分をコンストラクターを扱う形に変更して解消できた

``` java
    // finalを追加して変更不可とします
    private final UsersDao usersDao;

    // コンストラクタを追加して依存関係を注入します
    public Controller(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
``` 

### 3 - 環境構築＆ビルド手順

#### __環境構築__
- vscodeでjavaの拡張パックインストール
- mavenもしくはgradleのspring-bootプロジェクトを作成
- パッケージを追加 (SpringWeb, posgreQSL, JDBCなど) pom.xmlにdomaのパッケージ追加
- posgreSQLをインストール、テーブル作成など
- reactのプロジェクト作成
- spring-bootからreactへデータを渡せるようする

#### ビルド手順
- spring-bootを起動 ``` ./mvnw spring-boot:run ```
- reactを起動, reactのディレクトリ内で ``` npm  start ```

### 4 - 動画

https://github.com/ethanVodka/aas_sample/assets/75683178/15289da0-037e-44ef-b215-cc4e1b62b11d


