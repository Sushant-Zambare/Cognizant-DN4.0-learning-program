import React from 'react';

function CourseDetails(props) {
  const course1 = 'Angular';
  const course2 = 'React';

  return (
    <div className="mystyle1">
      <h1>Course Details</h1>

      {course1 === 'Angular' ? (
        <>
          <h2>{course1}</h2>
          <p>4/5/2021</p>
        </>
      ) : null}

      {course2 && (
        <>
          <h2>{course2}</h2>
          <p>6/3/20201</p>
        </>
      )}
    </div>
  );
}

export default CourseDetails;
