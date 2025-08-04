import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor() {
    super();
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: Math.floor(Math.random() * 100) + 1
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    var msg =
      'Thanks ' +
      this.state.ename +
      '\n Your Complaint was Submitted.\nTransaction ID is: ' +
      this.state.NumberHolder;
    alert(msg);
    event.preventDefault();
  }

  render() {
    return (
      <div>
        <h1 style={{ color: 'red', fontWeight: 'bold' }}>
          Register your complaints here!!!
        </h1>
        <form onSubmit={this.handleSubmit}>
          <label>Name:</label>
          <input
            type="text"
            name="ename"
            value={this.state.ename}
            onChange={this.handleChange}
          /><br /><br />
          <label>Complaint:</label>
          <textarea
            name="complaint"
            value={this.state.complaint}
            onChange={this.handleChange}
          /><br /><br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
