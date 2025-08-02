import React from 'react';

function BlogDetails(props) {
  const showReactBlog = true;
  const showInstallation = true;

  return (
    <div className="v1">
      <h1>Blog Details</h1>

      {showReactBlog && (
        <>
          <h2>React Learning</h2>
          <p><b>Stephen Biz</b></p>
          <p>Welcome to learning React!</p>
        </>
      )}

      {showInstallation ? (
        <>
          <h2>Installation</h2>
          <p><b>Schwezdenier</b></p>
          <p>You can install React from npm.</p>
        </>
      ) : null}
    </div>
  );
}

export default BlogDetails;
