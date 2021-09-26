import React from 'react';
import './Sidebar.css';
import { Home, Info, PermIdentity, LocalHospital } from "@material-ui/icons";
import { Link } from "react-router-dom";

export default function Sidebar() {
    return (
        <div className="sidebar">
            <div className="sidebarWrapper">
                <div className="sidebarMenu">
                    <h3 className="sidebarTitle">Dashboard</h3>
                    <ul className="sidebarList">
                        <Link to="/user" className="link">
                            <li className="sidebarListItem active">
                                <Home className="sidebarIcon" />
                                Home
                            </li>
                        </Link>
                        <li className="sidebarListItem">
                            <LocalHospital className="sidebarIcon" />
                            Health
                        </li>
                        <Link to="/doctors" className="link">
                            <li className="sidebarListItem">
                                <PermIdentity className="sidebarIcon" />
                                Doctors
                            </li>
                        </Link>
                        <li className="sidebarListItem">
                            <Info className="sidebarIcon" />
                            About Us
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}
