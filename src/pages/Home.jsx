
import { ExpenseRequest } from '../components/ExpenseRequest.jsx';
import Card from 'react-bootstrap/Card';


export const Home = () => {
  return (
    <Card bg="light" >
        <Card.Body>
            <Card.Header className="text-center" as="h4">Enter Reimbursement Request</Card.Header>
            <ExpenseRequest />
        </Card.Body>
    </Card>
    
  );
}