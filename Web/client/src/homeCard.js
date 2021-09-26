import React from 'react'
import {Card} from 'react-bootstrap'

export default function homeCard() {
    return (
        <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title style={{fontWeight:"bold", fontSize:"30px"}}>MedIoT</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">Complete remote healthcare solution</Card.Subtitle>
                <Card.Text>
                    Providing and efficient solution to remote healthcare system. We have all the best doctors you can think of.
                    We provide the best healthcare at your fingertips.
                </Card.Text>
            </Card.Body>
      </Card>
    )
}
