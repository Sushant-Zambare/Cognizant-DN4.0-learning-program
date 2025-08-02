import React from 'react';
import './App.css';
import OfficeCard from './components/OfficeCard';

function App() {
  const officeList = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: "/office1.jpg"
    },
    {
      name: "Regus",
      rent: 65000,
      address: "Mumbai",
      image: "/office2.jpg"
    }
  ];

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>
      <div className='card'>
        {officeList.map((office, index) => (
            <OfficeCard key={index} office={office} />
          ))}
      </div>
      
    </div>
  );
}

export default App;
