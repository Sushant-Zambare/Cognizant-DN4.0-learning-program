import React from 'react';

const OfficeCard = ({ office }) => {
  let rentClass = office.rent <= 60000 ? 'textRed' : 'textGreen';

  return (
    <div style={{ marginBottom: "30px" }}>
        {console.log(office.image)}
      <img src={office.image} width="50%" height="50%" alt="Office Space" />
      <h2>Name: {office.name}</h2>
      <h3 className={rentClass}>Rent: Rs. {office.rent}</h3>
      <h3>Address: {office.address}</h3>
    </div>
  );
};

export default OfficeCard;
