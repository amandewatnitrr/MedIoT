import React from 'react';
import './HealthInfo.css';
import { ArrowDownward, ArrowUpward } from "@material-ui/icons";


export default function HealthInfo() {

    const st1 = {
        backgroundColor: "#2dcaeb"
    };

    const st2 = {
        backgroundColor: "#22ae77"
    };

    const st3 = {
        backgroundColor: "#ff0e47"
    };

    return (
        <div className="featured">
            <div className="featuredItem" style={st1}>
                <span className="featuredTitle">Temperature</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">102</span>
                    <span className="featuredMoneyRate">
                        +5 <ArrowUpward className="featuredIcon negative" />
                    </span>
                </div>
                <span className="featuredSub">Normal Body Temperature is 97F</span>
            </div>
            <div className="featuredItem" style={st2}>
                <span className="featuredTitle">Pulse Rate</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">78</span>
                    <span className="featuredMoneyRate">
                        -7 <ArrowDownward className="featuredIcon negative" />
                    </span>
                </div>
                <span className="featuredSub">Normal Human Pulse Rate is 85</span>
            </div>
            <div className="featuredItem" style={st3}>
                <span className="featuredTitle">Respiration Rate</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">18</span>
                    <span className="featuredMoneyRate">
                        +4 <ArrowUpward className="featuredIcon" />
                    </span>
                </div>
                <span className="featuredSub">Normal Respiration Rate is 14</span>
            </div>
        </div>
    )
};
