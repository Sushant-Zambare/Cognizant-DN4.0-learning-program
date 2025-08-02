import React from 'react';
import './App.css';
import BookDetails, { books } from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  return (
    <div className="container">
      <CourseDetails />
      <BookDetails books={books} />
      <BlogDetails />
    </div>
  );
}

export default App;
