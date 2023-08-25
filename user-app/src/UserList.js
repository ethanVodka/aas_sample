import React, { useState, useEffect } from 'react';

function UserList() {
    // ユーザーのリストを管理するための状態
    const [users, setUsers] = useState([]);

    // コンポーネントがマウントされた後、一度だけ実行される
    useEffect(() => {
        // バックエンドのAPIからユーザーのリストを取得
        fetch('http://localhost:8080/')
            .then(response => response.json())  // レスポンスをJSON形式に変換
            .then(data => setUsers(data));      // ユーザーの状態を更新
    }, []);  // 空の依存配列を持つため、このエフェクトはマウント時にのみ実行される

    // ユーザーのリストを表示
    return (
        <ul>
            {users.map(user => (
                <li key={user.id}>{user.name}</li>  // 各ユーザーをリストアイテムとして表示
            ))}
        </ul>
    );
}

export default UserList;
