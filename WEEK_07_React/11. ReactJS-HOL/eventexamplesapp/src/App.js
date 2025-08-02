import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(5);
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const sayHello = () => {
    alert("Hello! Member!");
  };

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const euroAmount = amount * 80;
    alert(`Converting to ${currency} Amount is ${euroAmount}`);
  };

  return (
    <div style={{ padding: '20px' }}>
      <h3>{count}</h3>
      <button onClick={increment}>Increment</button><br />
      <button onClick={decrement}>Decrement</button><br />
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button><br />
      <button onClick={handleClick}>Click on me</button><br /><br />

      <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:  <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)} /><br />
        </label>
        <br />
        <label>
          Currency: <textarea value={currency} onChange={(e) => setCurrency(e.target.value)} />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
