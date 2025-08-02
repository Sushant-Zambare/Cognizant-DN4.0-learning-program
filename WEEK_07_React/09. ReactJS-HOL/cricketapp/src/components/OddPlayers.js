import React from 'react';

const OddPlayers = ({ IndianTeam }) => {
  const oddPlayers = IndianTeam.filter((_, index) => index % 2 === 0);
  const labels = ['First', 'Third', 'Fifth'];

  return (
    <ul>
      {oddPlayers.map((player, index) => (
        <li key={index}>{labels[index]} : {player}</li>
      ))}
    </ul>
  );
};

export default OddPlayers;
