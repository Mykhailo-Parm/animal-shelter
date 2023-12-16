import Table from 'react-bootstrap/Table';
import {useEffect, useState} from "react";
import UserService from "../../services/UserService";
import {Link} from "react-router-dom";

const UsersList = () => {
    const [users, setUsers] = useState([]);
    useEffect(() => {
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
                <th>#</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone number</th>
            </tr>
            </thead>
            <tbody>
            {users.map((user) => (

                    <tr key={user.id} >
                            <Link to={`/users/${user.id}`}><td className={"text-info"}>{user.id}</td></Link>
                            <td>{user.name}</td>
                            <td>{user.dob}</td>
                            <td>{user.email}</td>
                            <td>{user.address}</td>
                        <td>{user.phone_number}</td>

                    </tr>

            ))}

            </tbody>
        </Table>
    );
}

export default UsersList;