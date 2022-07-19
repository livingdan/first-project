import axios from "axios";
import { useState, useEffect } from "react";
import { Expense } from "./Expense";


export const ExpenseList = () => {
    const [requests, setRequests] = useState([]); 


    //page first loads
    useEffect(() => {
        axios.get('http://localhost:8080/first-project/')
        .then(res => setRequests(res.data)); // set requests from database
    },[]);

    return (
        <>
            <table>               
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Reason</th>
                        <th>Notes</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {requests.map((request) => {
                        return (
                        <Expense key={request.id} request={request} requests={requests} setRequests={setRequests}/>
                        );
                    })}
                </tbody>

            </table>
        </>
    );
}