import React from 'react'
import LoginPage from './loginPage';
import Home from './Home';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import UserDash from './pages/home/Home';
import Doctors from './pages/doctors/Doctors';

export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path="/">
                    <Home></Home>
                </Route>
                <Route exact path="/login">
                    <LoginPage />
                </Route>
                <Route exact path="/user">
                    <UserDash></UserDash>
                </Route>
                <Route exact path="/doctors">
                    <Doctors />
                </Route>

            </Switch>

        </Router>
    )
}
