import React,{useState} from 'react'
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import HomeCard from './homeCard';
import HomeHeader from './homeHeader';
import doctorImg from "./images/doctorImg.jpg";
import { Redirect } from 'react-router-dom';

export default function Home() {
    const [redirect,setRedirect] = useState(false);
    return (
        <>
        {
        redirect
        ?
        (<Redirect to='/login'/>)
        :
        null
      }
        <div style={{backgroundImage:`url(${doctorImg})`,backgroundRepeat:'repeat'}}>
            <HomeHeader />
            <Container style={{marginTop:"15%",marginLeft:"40%"}}>
                <Row>
                    <Col md={8}>
                        <HomeCard></HomeCard>
                    </Col>
                </Row>
                <Row>
                    <Col md={8}>
                        <Button variant="success" size="lg" style={{width:"200px"}} onClick={()=>{setRedirect(true)}}>Login</Button>
                    </Col>
                </Row>
            </Container>
        </div>
        </>
    )
}
