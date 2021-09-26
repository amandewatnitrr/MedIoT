import React from 'react'
import {Container,Row,Col} from 'react-bootstrap'

import PatientCard from './loginPatienCard';
import DoctorCard from './loginDoctorCard';
import LoginDoctorButton from './loginDoctorButton';
import LoginpatientButton from './loginpatientButton';

export default function Login() {
    return (
        <Container style={{marginTop:"10%",marginLeft:"15%"}}>
            <Row>
                <Col md={6}>
                    <h1>Login</h1>
                </Col>
            </Row>
            <Row>
                <Col md={6}>
                    <PatientCard/>
                </Col>
                <Col md={6}>
                   <DoctorCard/>
                </Col>
            </Row>
            <Row>
                <Col md={6}>
                    <LoginpatientButton />
                </Col>
                <Col md={6}>
                    <LoginDoctorButton />
                </Col>
            </Row>
        </Container>
    )
}
