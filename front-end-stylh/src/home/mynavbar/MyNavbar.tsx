import React from "react";
import Nav from "react-bootstrap/Nav";
import NavbarBrand from "react-bootstrap/NavbarBrand"
import NavbarToggle from "react-bootstrap/NavbarToggle";
import NavbarCollapse from "react-bootstrap/NavbarCollapse";
import {NavDropdown} from "react-bootstrap";
import Navbar from "react-bootstrap/Navbar";


class MyNavbar extends React.Component {
    render() {
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <NavbarBrand href="#home">STYLH</NavbarBrand>
                <NavbarToggle aria-controls="responsive-navbar-nav" />
                <NavbarCollapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="#features">News</Nav.Link>
                        <NavDropdown title="Forums" id="forum-dropdown-navbar">
                            <NavDropdown.Item href={"#action"}>New Posts</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Latests" id="latest-dropdown-navbar">
                            <NavDropdown.Item href="#action/3.1">New posts</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">New profile posts</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Latest activity</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Members" id="member-dropdown-navbar">
                            <NavDropdown.Item href="#action/3.1">Current visitors</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">New profile posts</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="#features">pik.vn</Nav.Link>
                    </Nav>
                    <Nav>
                        <Nav.Link href="#deets">Login</Nav.Link>
                        <Nav.Link eventKey={2} href="#memes">
                            Register
                        </Nav.Link>
                    </Nav>
                </NavbarCollapse>
            </Navbar>
        )
    }
}

export default MyNavbar
