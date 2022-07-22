import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { ListRequests } from './pages/ListRequests';
import { Navigation } from './components/Navigation';
import Nav from 'react-bootstrap/Nav';

function App() {
  return (
    <>
    <BrowserRouter>
    <Navigation>
      <Nav.Item>
        <Nav.Link href="/">Make Request</Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link href="/list_requests">Manage Requests</Nav.Link>
      </Nav.Item>
    </Navigation>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/list_requests" element={<ListRequests />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
