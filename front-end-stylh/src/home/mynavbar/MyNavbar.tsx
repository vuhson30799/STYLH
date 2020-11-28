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
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" fixed={"top"} className={"my-navbar"}>
                <NavbarBrand href="/">STYLH</NavbarBrand>
                <NavbarToggle aria-controls="responsive-navbar-nav"/>
                <NavbarCollapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="#features">News</Nav.Link>
                        <Nav.Link href="/">Forums</Nav.Link>
                        <NavDropdown title="Latests" id="latest-dropdown-navbar">
                            <NavDropdown.Item href="/whats-new/posts">New posts</NavDropdown.Item>
                            <NavDropdown.Item href="/whats-new/profile-posts">New profile posts</NavDropdown.Item>
                            <NavDropdown.Item href="/whats-new/latest-activity">Latest activity</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="/online">Members</Nav.Link>
                    </Nav>
                    <Nav>
                        <Nav.Link href="">Login</Nav.Link>
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
