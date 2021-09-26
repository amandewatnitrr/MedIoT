import React from 'react';
import Navbar from '../../dashboard/navbar/Navbar';
import Sidebar from '../../dashboard/sidebar/Sidebar';
import HealthInfo from '../../dashboard/healthinfo/HealthInfo';
import Chart from '../../dashboard/chart/Chart';
import './Home.css';

export default function Home() {
    return (
        <div>
            <Navbar />
            <div className="mycontainer">
                <Sidebar />
                <div className="home">
                    <HealthInfo />
                    <Chart />
                </div>
            </div>

        </div>
    )
}

<div className="mycontainer">
    <Sidebar />
</div>
