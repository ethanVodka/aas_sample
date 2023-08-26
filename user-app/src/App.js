import React from 'react';
import UserList from './UserList';
import UserForm from './UserForm';
import './App.css'; 

function App() {
  return (
    <div className="App">
      <UserForm />
      <UserList />
    </div>
  );
}

export default App;
