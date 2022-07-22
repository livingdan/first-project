
import { ExpenseList } from '../components/ExpenseList';
import Card from 'react-bootstrap/Card';


export const ListRequests = () => {
  return (
    <Card bg="light" className="text-center">
        <Card.Body>
        <Card.Header as="h4">Expense Reimbursement List</Card.Header>
            <ExpenseList />
        </Card.Body>
    </Card>
  );
}