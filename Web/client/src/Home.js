import React from 'react'

import {Container, Row, Col, Card} from 'react-bootstrap';
import HomeCard from './homeCard';
import HomeHeader from './homeHeader';

export default function Home() {
    return (
        <>
        <HomeHeader/>
        <Container>
            <Row>
                <Col md={8}>
                    <HomeCard></HomeCard>
                </Col>
            </Row>
        </Container>
        </>
    )
}
