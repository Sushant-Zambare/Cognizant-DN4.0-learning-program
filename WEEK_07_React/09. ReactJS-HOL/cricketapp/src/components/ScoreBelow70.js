import React from 'react';

const ScoreBelow70 = ({ players }) => {
  const filtered = players.filter(player => player.score <= 70);

  return (
    <ul>
      {filtered.map((player, index) => (
        <li key={index}>{player.name} - {player.score}</li>
      ))}
    </ul>
  );
};

export default ScoreBelow70;
