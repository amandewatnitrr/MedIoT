import React from 'react'

import {Card} from 'react-bootstrap'

export default function loginDoctorCard() {
    return (
        <Card style={{ width: '18rem' }}>
        <Card.Body>
          <Card.Title style={{fontWeight:"bold", fontSize:"30px"}}>For Doctors</Card.Title>
          <Card.Subtitle className="mb-2 text-muted">Your tool for remote monitoring</Card.Subtitle>
          <Card.Text>
            Some quick example text to build on the card title and make up the bulk of
            the card's content.
          </Card.Text>
        </Card.Body>
      </Card>
    )
}
