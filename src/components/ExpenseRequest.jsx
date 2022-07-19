import { useRef } from "react";
import axios from "axios";

export const ExpenseRequest = () => {
    const nameRef = useRef();
    const reasonRef = useRef();
    const notesRef = useRef();
    


    const handleSubmit = async (event) => {
        try {
            event.preventDefault();

            const {data} = await axios.post('http://localhost:8080/first-project/',
            {
            name: nameRef.current.value,
            reason: reasonRef.current.value,
            notes: notesRef.current.value
             }
            );
            
            nameRef.current.value = null;
            reasonRef.current.value = null;
            notesRef.current.value = null;
        } catch (err) {
            console.error(err);
        }
        

    }

    return (
        <form onSubmit={handleSubmit}>
        <div>
            <label htmlFor="name">Name:</label>
            <input name="name" ref={nameRef} placeholder='Enter Name' />
        </div>
        <div>
            <label htmlFor="reason">Reason:</label>
            <input name="reason" ref={reasonRef} placeholder='Enter reason for reimbursement' />
        </div>
        <div>
            <label htmlFor="notes">Notes:</label>
            <input name="notes" ref={notesRef} placeholder='Enter additional notes'/>
        </div>
        <div>
            <button>Submit Request</button>
        </div>
        </form>
    )

}
