import React from 'react';
import "./Navbar.css";
import { Settings } from "@material-ui/icons";
import userImage from '../../images/user.png';

export default function Navbar() {
    return (
        <div className="navbar">
            <div className="navbarWrapper">
                <div className="navLeft">
                    <span className="logo">Dashboard</span>
                </div>
                <div className="navRight">
                    <div className="navbarIconContainer">
                        <Settings />
                    </div>
                    <img src={userImage} alt="" className="navAvatar" />
                </div>
            </div>
        </div>
    )
}
