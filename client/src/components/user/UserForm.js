import {Button, Form} from "react-bootstrap";
import Container from "react-bootstrap/Container";
import UserService from "../../services/UserService";
import {useState} from "react";

function UserForm () {
    const [formData, setFormData] = useState({
        "id": 0,
        "name": "",
        "email": "",
        "dob": "",
        "address": "",
        "phone_number": ""
    });

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const objToPost = {
                id: 0,
                name: formData.name,
                email: formData.email,
                dob: formData.dob,
                address: formData.address,
                phone_number: formData.phone_number
            }
            await UserService.createUser(objToPost);
            setFormData({
                id: 0,
                name: "",
                email: "",
                date_of_birth: "",
                address: "",
                phone_number: "",
            });

        } catch (error) {
            console.error('Error submitting form:', error);
        }
    };

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
                    <Form.Label>Name</Form.Label>
                    <Form.Control
                        type="text"
                        name="name"
                        placeholder="John"
                        value={formData.name}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control
                        type="email"
                        name="email"
                        placeholder="name@example.com"
                        value={formData.email}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control
                        type="date"
                        name="dob"
                        value={formData.dob}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                    <Form.Label>Address</Form.Label>
                    <Form.Control
                        type="text"
                        name="address"
                        placeholder="Main str. 10"
                        value={formData.address}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput5">
                    <Form.Label>Phone number</Form.Label>
                    <Form.Control
                        type="tel"
                        name="phone_number"
                        placeholder="+1234567890"
                        value={formData.phone_number}
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

export default UserForm;