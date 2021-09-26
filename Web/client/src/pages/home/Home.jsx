import React from 'react';
import HealthInfo from '../../dashboard/healthinfo/HealthInfo';
import Chart from '../../dashboard/chart/Chart';
import './Home.css';

export default function Home() {
    return (
        <div className="home">
            <HealthInfo />
            <Chart />
        </div>
    )
}
