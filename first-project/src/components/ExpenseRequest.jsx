import { useRef, useState } from "react";
import axios from "axios";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import {SuccessModal} from './SuccessModal';


export const ExpenseRequest = () => {
    const nameRef = useRef();
    const reasonRef = useRef();
    const notesRef = useRef();
    const [modalShow, setModalShow] = useState(false);
    


    const handleSubmit = async (event) => {
        try {
            event.preventDefault();

            await axios.post('http://localhost:8080/first-project/',
            {
            name: nameRef.current.value,
            reason: reasonRef.current.value,
            notes: notesRef.current.value
             }
            );
            
            nameRef.current.value = null;
            reasonRef.current.value = null;
            notesRef.current.value = null;
            setModalShow(true)
        } catch (err) {
            console.error(err);
        }
    }

    return (
        <>
        <Form onSubmit={handleSubmit}>
            <Form.Group>
                <Form.Label >Name:</Form.Label>
                <Form.Control name="name" ref={nameRef} required placeholder='Enter Name' />
            </Form.Group>
            <Form.Group>
                <Form.Label >Reason:</Form.Label>
                <Form.Control name="reason" ref={reasonRef} required placeholder='Enter reason for reimbursement' />
            </Form.Group>
            <Form.Group>
                <Form.Label >Notes:</Form.Label>
                <Form.Control name="notes" ref={notesRef} placeholder='Enter additional notes'/>
            </Form.Group>
            
            <Button variant="success" type="submit" >
            Submit Request
            </Button>
            
        </Form>
        <SuccessModal
        show={modalShow}
        onHide={() => setModalShow(false)}
      />
        </>
    )

}
