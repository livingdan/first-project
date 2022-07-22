import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

export const SuccessModal = (props) => {
  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
        Request Submitted!
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <p>
          Your expense reimbursement request has been succesfully submitted.
        </p>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={props.onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
}