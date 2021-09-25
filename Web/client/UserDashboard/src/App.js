import React from 'react';
import './App.css';
import Navbar from './dashboard/navbar/Navbar';
import Sidebar from './dashboard/sidebar/Sidebar';
import Home from './pages/home/Home';
import Doctors from './pages/doctors/Doctors';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
    return (
        <Router>
            <Navbar />
            <div className="container">
                <Sidebar />
                <Switch>
                    <Route exact path="/">
                        <Home />
                    </Route>
                    <Route exact path="/doctors">
                        <Doctors />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

export default App;
