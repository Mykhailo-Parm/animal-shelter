import {useState} from "react";
import WalksService from "../../services/WalksService";
import {Button, Form} from "react-bootstrap";
import Container from "react-bootstrap/Container";

const BookWalkForm = () => {
    const [formData, setFormData] = useState({
        idUser: "",
        idAnimal: "",
        date_of_walk: "",
        duration: ""
    })
    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const objToPost = {
                idUser: formData.idUser,
                idAnimal: formData.idAnimal,
                date_of_walk: formData.date_of_walk,
                duration: formData.duration
            }
            await WalksService.createBookedWalk(objToPost);
            setFormData({
                idUser: 0,
                idAnimal: 0,
                date_of_walk: "",
                duration: 0
            });
        } catch (error) {
            console.error('Error submitting form:', error);
        }
    }
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };
    return (
        <Container className="justify-content-sm-center-center">
            <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>User id</Form.Label>
                    <Form.Control
                        type="text"
                        name="idUser"
                        placeholder="1, 2, 3..."
                        value={formData.idUser}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Animal id</Form.Label>
                    <Form.Control
                        type="text"
                        name="idAnimal"
                        placeholder="1, 2, 3..."
                        value={formData.idAnimal}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
                    <Form.Label>Date of walk</Form.Label>
                    <Form.Control
                        type="date"
                        name="date_of_walk"
                        value={formData.date_of_walk}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                    <Form.Label>Duration</Form.Label>
                    <Form.Control
                        type="text"
                        name="duration"
                        placeholder="120, 60..."
                        value={formData.duration}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Button
                    variant="primary"
                    type="submit"
                    onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </Container>
    )
}
export default BookWalkForm;