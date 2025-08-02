import React from 'react';

const EvenPlayers = ({ IndianTeam }) => {
  const evenPlayers = IndianTeam.filter((_, index) => index % 2 !== 0);
  const labels = ['Second', 'Fourth', 'Sixth'];

  return (
    <ul>
      {evenPlayers.map((player, index) => (
        <li key={index}>{labels[index]} : {player}</li>
      ))}
    </ul>
  );
};

export default EvenPlayers;
