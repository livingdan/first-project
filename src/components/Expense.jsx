import { useState } from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";


export const Expense = ({request, setRequests, requests}) => {
    const [deleteRender, setDeleteRender] = useState(request.status.statusId !== 1);
    const [approveRender, setapproveRender] = useState(request.status.statusId === 1);

    const rowColor = (status) => {
        switch(status){
        case 2:
            return "table-success";
        case 3:
            return "table-danger";
        default:
            return "table-info";
        }
    }

    const handleDelete = async (e) => {
        try {
            e.preventDefault();
            await axios.delete(`http://localhost:8080/first-project/${request.id}`);
            setRequests(requests.filter(req => request.id !== req.id));
        } catch (err) {
            console.error(err);
        }
    }

    const handleApprove = async (e) => {
        try {
            e.preventDefault();
            await axios.put('http://localhost:8080/first-project/',
                {
                    id: request.id,
                    name: request.name,
                    reason: request.reason,
                    notes: request.notes,
                    status: {
                        statusId: 2,
                        status: "Approved"
                    }
                }


            );
            setapproveRender(false);
            setDeleteRender(true);

            request.status = {
                statusId: 2,
                status: "Approved"
            }
            setRequests(requests);
        } catch (err) {
            console.error(err);
        }
    }

    const handleDeny = async (e) => {
        try {
            e.preventDefault();
            await axios.put('http://localhost:8080/first-project/',
                {
                    id: request.id,
                    name: request.name,
                    reason: request.reason,
                    notes: request.notes,
                    status: {
                        statusId: 3,
                        status: "Denied"
                    }
                }
            );
            setapproveRender(false);
            setDeleteRender(true);

            request.status = {
                statusId: 3,
                status: "Denied"
            }
            setRequests(requests);
            
        } catch (err) {
            console.error(err);
        }
    }



    return (
        <tr className={rowColor(request.status.statusId)} >
            <td>{request.name}</td>
            <td>{request.reason}</td>
            <td>{request.notes}</td>
            <td>{request.status.status}</td>
            <td>
            {deleteRender && <Button variant="danger" onClick={handleDelete}>Delete</Button>}
            {approveRender && <Button variant="success" onClick={handleApprove}>Approve</Button>}
            {approveRender && <Button variant="warning" onClick={handleDeny}>Deny</Button>}
            </td>
            
        </tr>
    )

}