import React from 'react';
import CanvasJSReact from '../chartdata/canvasjs.react';
const CanvasJSChart = CanvasJSReact.CanvasJSChart;

export default function Chart() {

    const myStyle = {
        marginTop: "40px"
    }
    const options = {
        animationEnabled: true,
        title: {
            text: "Monitoring Your Health"
        },
        subtitles: [{
            text: "IoT",
            verticalAlign: "center",
            fontSize: 32,
            dockInsidePlotArea: true
        }],
        data: [{
            type: "doughnut",
            showInLegend: true,
            indexLabel: "{name}: {y}",
            yValueFormatString: "#,###",
            dataPoints: [
                { name: "Temperature", y: 102 },
                { name: "Pulse Rate", y: 78 },
                { name: "Respiration Rate", y: 18 }
            ]
        }]
    }
    return (
        <div style={myStyle}>
            <CanvasJSChart options={options} />
        </div>
    )
}
