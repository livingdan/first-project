import axios from "axios";

export const Expense = ({request, setRequests, requests}) => {

    const handleDelete = async (e) => {
        try {
            e.preventDefault();
            //await axios.delete(`http://localhost:8080/first-project/${request.id}`)
            setRequests(requests.filter(req => request.id != req.id));
        } catch (err) {
            console.error(err);
        }
    }

    return (
        <tr>
            <td>{request.name}</td>
            <td>{request.reason}</td>
            <td>{request.notes}</td>
            <td>{request.status.status}</td>
            <button onClick={handleDelete}>Delete</button>

        </tr>
    )

}