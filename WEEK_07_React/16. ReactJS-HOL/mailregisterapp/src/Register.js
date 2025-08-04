import React from 'react';

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5
          ? 'Full Name must be 5 characters long!'
          : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(/^([^\s@]+@[^\s@]+\.[^\s@]+)$/);
        errors.email = validEmailRegex.test(value)
          ? ''
          : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8
          ? 'Password must be 8 characters long!'
          : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  }

  validateForm = (errors) => {
    return Object.values(errors).every(err => err === '');
  }

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validateForm(this.state.errors)) {
      alert('Valid Form');
    } else {
      if (this.state.errors.fullName !== '') {
        alert(this.state.errors.fullName);
      }
      if (this.state.errors.email !== '') {
        alert(this.state.errors.email);
      }
      if (this.state.errors.password !== '') {
        alert(this.state.errors.password);
      }
    }
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "150px" }}>
        <h1 style={{ color: "red", fontWeight: "bold" }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:</label>
            <input type="text" name="fullName" onChange={this.handleChange} />
          </div>
          <div>
            <label>Email:</label>
            <input type="text" name="email" onChange={this.handleChange} />
          </div>
          <div>
            <label>Password:</label>
            <input type="password" name="password" onChange={this.handleChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;
