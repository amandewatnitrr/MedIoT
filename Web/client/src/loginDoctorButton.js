import React, {useState} from 'react'
import { Button, Modal, Container, Row, Col } from 'react-bootstrap'

export default function LoginDoctorButton() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const doctorLogin = () => {
        /**
         * We can implement login functionality in this function
         * Matching from firebase can be done
         */
        console.log("Doctor login");
    }
    return (
       <>
            <Button variant="success" size="lg"  onClick={handleShow}>Login</Button>
            <Modal show={show} onHide={handleClose} style={{opacity:1,top:"20%"}} backdrop="static"
        keyboard={false}>
         <Modal.Header closeButton>
          <Modal.Title style={{fontWeight:"bold",fontSize:"30px",paddingTop:"30px",marginLeft:"2%"}}>Login</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Container>
                <Row>
                    <Col md={8} style={{padding:"10px"}}>
                        <input type="email" placeholder="Enter your email" style={{"width":"50%","borderRadius":"7px"}}></input>
                    </Col>
                    <Col md={8} style={{padding:"10px"}}>
                        <input type="password" placeholder="Enter your password" style={{"width":"50%","borderRadius":"7px"}}></input>
                    </Col>
                </Row>
            </Container>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="success" onClick={doctorLogin}>
            Login
          </Button>
        </Modal.Footer>
      </Modal>
       </>
    )
}
