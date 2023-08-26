import React, { useState } from 'react';
import './UserForm.css'

function UserForm() {
    // ユーザーの名前を管理するための状態
    const [name, setName] = useState('');

    // フォームの送信時に実行される関数
    const handleSubmit = (e) => {
        e.preventDefault();  // デフォルトの送信動作を停止
        // バックエンドのAPIにPOSTリクエストを送る
        fetch('http://localhost:8080/', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name })
        }).then(() => {
            setName('');  // 名前の状態を初期化
            window.location.reload(); // ページをリロードしてデータを最新の状態に更新
        });
    };

    // ユーザー入力フォームのUI
    return (
        <form onSubmit={handleSubmit}>
            <input 
                value={name} 
                onChange={e => setName(e.target.value)}  // 入力値が変わるたびに名前の状態を更新
                placeholder="User name" 
            />
            <button type="submit">Add User</button>  
        </form>
    );
}

export default UserForm;
