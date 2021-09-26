import React,{useState} from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap'
import "./homeHeader.css";
import { Redirect } from 'react-router-dom';

export default function HomeHeader() {
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
        <div className="navbar">
            <div className="navbarWrapper">
                <div className="navLeft">
                    <span className="logo">MedIoT</span>
                </div>
                <div className="navRight">
                    <div className="navbarIconContainer">
                       <Button variant="success" size="lg" onClick={()=>{setRedirect(true)}}>Login</Button>
                    </div>
                    
                </div>
            </div>
        </div>
        </>
    )
}
