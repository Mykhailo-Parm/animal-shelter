import {useState} from "react";
import AnimalService from "../../services/AnimalService";
import Container from "react-bootstrap/Container";
import {Button, Form} from "react-bootstrap";

const AnimalForm = () => {
    const [formData, setFormData] = useState({
        id: 0,
        species: "",
        breed: "",
        name: "",
        date_of_birth: "",
        gender: "",
        description: "",
        color: "",
    });
    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const objToPost = {
                id: 0,
                species: formData.species,
                breed: formData.breed,
                name: formData.name,
                date_of_birth: formData.date_of_birth,
                gender: formData.gender,
                description: formData.description,
                color: formData.color
            }
            await AnimalService.createAnimal(objToPost);
            setFormData({
                id: 0,
                species: "",
                breed: "",
                name: "",
                date_of_birth: "",
                gender: "",
                description: "",
                color: ""
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
                    <Form.Label>Species</Form.Label>
                    <Form.Control
                        type="text"
                        name="species"
                        placeholder="dog, cat"
                        value={formData.species}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Breed</Form.Label>
                    <Form.Control
                        type="text"
                        name="breed"
                        placeholder="Husky, Persian"
                        value={formData.breed}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
                    <Form.Label>Name</Form.Label>
                    <Form.Control
                        type="text"
                        name="name"
                        placeholder="Mia"
                        value={formData.name}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                    <Form.Label>Date of birth</Form.Label>
                    <Form.Control
                        type="date"
                        name="date_of_birth"
                        value={formData.date_of_birth}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput5">
                    <Form.Label>Gender</Form.Label>
                    <Form.Control
                        type="text"
                        name="gender"
                        placeholder="male/female"
                        value={formData.gender}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput6">
                    <Form.Label>Description</Form.Label>
                    <Form.Control
                        type="text"
                        name="description"
                        placeholder="Description..."
                        value={formData.description}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput7">
                    <Form.Label>Color</Form.Label>
                    <Form.Control
                        type="text"
                        name="color"
                        placeholder="grey"
                        value={formData.color}
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

export default AnimalForm;