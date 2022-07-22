import Nav from 'react-bootstrap/Nav';
import { Navbar } from 'react-bootstrap';


export const Navigation = ({children}) => {
    return (
        <Navbar bg="light" className="justify-content-center">
        <Nav as="h3" variant="tabs" >
            {children}
        </Nav>
        </Navbar>


    );
}