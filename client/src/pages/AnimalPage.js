import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Table from "react-bootstrap/Table";
import AnimalService from "../services/AnimalService";
import {Button} from "react-bootstrap";


function AnimalPage() {
    const {animalID} = useParams();
    const [animal, setAnimal] = useState();
    const navigate = useNavigate();
    useEffect(() => {
        const fetchAnimal = async () => {
            try {
                const fetchedAnimal = await AnimalService.getAnimal(animalID);
                setAnimal(fetchedAnimal);
            } catch (error) {
                console.error('Error fetching animal:', error);
            }
        };

        fetchAnimal();
    }, [animalID]);
    const handleDelete = async () => {
        try {
            await AnimalService.deleteAnimal(animalID);
            navigate('/animals');
        } catch (error) {
            console.error('Error deleting animal:', error);
        }
    };
    return (
        <>
            <Table striped bordered hover>
                <tbody>
                <tr>
                    <td>Id</td>
                    <td>{animal?.id}</td>
                </tr>
                <tr>
                    <td>Species</td>
                    <td>{animal?.species}</td>
                </tr>
                <tr>
                    <td>Breed</td>
                    <td>{animal?.breed}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>{animal?.name}</td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td>{animal?.date_of_birth}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>{animal?.gender}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>{animal?.description}</td>
                </tr>
                <tr>
                    <td>Color</td>
                    <td>{animal?.color}</td>
                </tr>
                </tbody>
            </Table>
            <Button  variant="danger" onClick={handleDelete}>
                DELETE ANIMAL
            </Button>
        </>
    )

}


export default AnimalPage;