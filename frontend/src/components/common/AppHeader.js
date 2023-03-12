import React, { Component } from "react";
import { Link, NavLink } from "react-router-dom";
import "./AppHeader.css";
import Clock from "./Clock";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

class AppHeader extends Component {
  constructor(props) {
    super(props);
    this.state = {
      date: new Date(),
    };
    this.handleDateChange = this.handleDateChange.bind(this);
  }
  

  handleDateChange(value) {
    this.setState({
      date: value,
    });
    this.props.handleCurrentDateChange(value);
  }

  // formatDate(date) {
  //   const year = date.getFullYear();
  //   const month = date.getMonth() + 1;
  //   const day = date.getDate();
  //   return `${year}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;
  // }
  formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    return `${year}-${month}-${day}`;
  }
  

  render() {
    return (
      <header className="app-header">
        <div className="container">
          <div className="app-branding">
            <Link to="/" className="app-title">
              KiddoArmour
            </Link>
          </div>
          <div className="app-options">
            <nav className="app-nav">
              {this.props.authenticated ? (
                <ul>
                  {/* <li className="label">Todays Date:</li>
                  <li>
                    <DatePicker
                      ariaLabelledBy="Set current date:"
                      className="transparent"
                      selected={this.state.date}
                      onChange={this.handleDateChange}
                      placeholderText="Change to date"
                    />
                  </li>
                  <li>{this.formatDate(this.state.date)}</li> */}
                  {/* <li>
                    <Clock />
                  </li> */}
                  <li>
                    <a href="/" onClick={this.props.onLogout}>
                      Logout
                    </a>
                  </li>
                </ul>
              ) : (
                <ul>
                  <li>
                    <NavLink to="/login">Login</NavLink>
                  </li>
                  <li>
                    <NavLink to="/signup">Signup</NavLink>
                  </li>
                </ul>
              )}
            </nav>
          </div>
        </div>
      </header>
    );
  }
}

export default AppHeader;

/*
import React, { Component } from "react";
import { Link, NavLink } from "react-router-dom";
import "./AppHeader.css";
import Clock from "./Clock";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

class AppHeader extends Component {
  constructor(props) {
    super(props);
    this.state = {
      date: new Date(),
    };
    this.handleDateChange = this.handleDateChange.bind(this);
  }

  handleDateChange(value) {
    this.setState({
      date: value,
    });
    this.props.handleCurrentDateChange(value);
  }

  render() {
    return (
      <header className="app-header">
        <div className="container">
          <div className="app-branding">
            <Link to="/" className="app-title">
              KiddoArmour
            </Link>
          </div>
          <div className="app-options">
            <nav className="app-nav">
              {this.props.authenticated ? (
                <ul>
                  <li className="label">Todays Date:</li>
                  <li>
                    <DatePicker
                      ariaLabelledBy="Set current date:"
                      className="transparent"
                      selected={this.state.date}
                      onChange={this.handleDateChange}
                      placeholderText="Change to date"
                    />
                  </li>
                  <li>
                    <Clock />
                  </li>
                  <li>
                    <a href="/" onClick={this.props.onLogout}>
                      Logout
                    </a>
                  </li>
                </ul>
              ) : (
                <ul>
                  <li>
                    <NavLink to="/login">Login</NavLink>
                  </li>
                  <li>
                    <NavLink to="/signup">Signup</NavLink>
                  </li>
                </ul>
              )}
            </nav>
          </div>
        </div>
      </header>
    );
  }
}

export default AppHeader;
*/