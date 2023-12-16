import {useEffect, useState} from "react";
import WalksService from "../../services/WalksService";
import Table from "react-bootstrap/Table";
import UserService from "../../services/UserService";
import AnimalService from "../../services/AnimalService";

const BookedWalksList = () => {
    const [bookedWalks, setBookedWalks] = useState([]);
    const [users, setUsers] = useState([]);
    const [animals, setAnimals] = useState([]);

    useEffect(() => {
        const fetchBookedWalks = async () => {
            try {
                const fetchedBookedWalks = await WalksService.getAllBookedWalks();
                setBookedWalks(fetchedBookedWalks);
            } catch (error) {
                console.error('Error fetching booked walks:', error);
            }
        };
        fetchBookedWalks();
        const fetchAnimals = async () => {
            try {
                const fetchedAnimals = await AnimalService.getAllAnimals();
                setAnimals(fetchedAnimals);
            } catch (error) {
                console.error('Error fetching animals:', error);
            }
        };
        fetchAnimals();
        const fetchUsers = async () => {
            try {
                const fetchedUsers = await UserService.getAllUsers();
                setUsers(fetchedUsers);
            } catch (error) {
                console.error('Error fetching users:', error);
            }
        };
        fetchUsers();

    });
    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>Name of Visitor</th>
                <th>Name of animal</th>
                <th>Date of walk</th>
                <th>Duration (in minutes)</th>
            </tr>
            </thead>
            <tbody>
            {bookedWalks.map((bookedWalk) => {
                const user = users.find(u => u.id === bookedWalk.idUser);
                const animal = animals.find(a => a.id === bookedWalk.idAnimal);
                return (
                    <tr key={user.id}>
                        <td>{user.name} ({user.id})</td>
                        <td>{animal.name} ({animal.id})</td>
                        <td>{bookedWalk.date_of_walk}</td>
                        <td>{bookedWalk.duration}</td>
                    </tr>
                )
            })}
            </tbody>
        </Table>
    );
}
export default BookedWalksList;