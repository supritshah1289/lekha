import React, { Component } from "react";
import { Route, Routes } from "react-router-dom";
import AppHeader from "../common/AppHeader";
import Home from "../home/Home";
import Login from "../user/login/Login";
import Signup from "../user/signup/Signup";
import Profile from "../user/profile/Profile";
import OAuth2RedirectHandler from "../user/oauth2/OAuth2RedirectHandler";
import NotFound from "../common/NotFound";
import LoadingIndicator from "../common/LoadingIndicator";
import { getCurrentUser } from "../util/APIUtils";
import { ACCESS_TOKEN } from "../constants";
import PrivateRoute from "../common/PrivateRoute";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      authenticated: false,
      currentUser: null,
      loading: true,
    };

    this.loadCurrentlyLoggedInUser = this.loadCurrentlyLoggedInUser.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  loadCurrentlyLoggedInUser() {
    getCurrentUser()
      .then((response) => {
        this.setState({
          currentUser: response,
          authenticated: true,
          loading: false,
        });
      })
      .catch((error) => {
        this.setState({
          loading: false,
        });
      });
  }

  handleLogout() {
    localStorage.removeItem(ACCESS_TOKEN);
    this.setState({
      authenticated: false,
      currentUser: null,
    });
    toast.success("You're safely logged out!", {
      position: toast.POSITION.TOP_CENTER,
    });
  }

  UNSAFE_componentWillMount() {
    this.loadCurrentlyLoggedInUser();
  }

  render() {
    if (this.state.loading) {
      return <LoadingIndicator />;
    }

    return (
      <div className="app">
        <div className="app-top-box">
          <AppHeader
            authenticated={this.state.authenticated}
            onLogout={this.handleLogout}
          />
        </div>
        <div className="app-body">
          <Routes>
            <Route exact path="/" element={<Home />}></Route>
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route
              path="/oauth2/redirect"
              element={OAuth2RedirectHandler}
            ></Route>
            <Route element={NotFound}></Route>
          </Routes>
        </div>
        <ToastContainer />
      </div>
    );
  }
}

export default App;
