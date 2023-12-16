import Table from 'react-bootstrap/Table';
import {useEffect, useState} from "react";
import AnimalService from "../../services/AnimalService";
import {Link} from "react-router-dom";

const AnimalsList = () => {
    const [animals, setAnimals] = useState([]);
    useEffect(() => {

        const fetchAnimals = async () => {
            try {
                const fetchedAnimals = await AnimalService.getAllAnimals();
                setAnimals(fetchedAnimals);
            } catch (error) {
                console.error('Error fetching animals:', error);
            }
        };

        fetchAnimals();
    });
    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>#</th>
                <th>Species</th>
                <th>Breed</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Description</th>
                <th>Color</th>
            </tr>
            </thead>
            <tbody>
            {animals.map((animal) => (
                <tr key={animal.id}>
                    <Link to={`/animals/${animal.id}`}><td className={"text-info"}>{animal.id}</td></Link>
                    <td>{animal.species}</td>
                    <td>{animal.breed}</td>
                    <td>{animal.name}</td>
                    <td>{animal.date_of_birth}</td>
                    <td>{animal.gender}</td>
                    <td>{animal.description}</td>
                    <td>{animal.color}</td>
                </tr>
            ))}

            </tbody>
        </Table>
    );
}

export default AnimalsList;