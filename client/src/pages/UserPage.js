import {useNavigate, useParams,} from "react-router-dom";
import {useEffect, useState} from "react";
import UserService from "../services/UserService";
import Table from "react-bootstrap/Table";
import {Button} from "react-bootstrap";


function UserPage() {
    const {userID} = useParams();
    const [user, setUser] = useState();
    const navigate = useNavigate();
    useEffect(() => {
        const fetchUser = async () => {
            try {
                const fetchedUser = await UserService.getUser(userID);
                setUser(fetchedUser);
            } catch (error) {
                console.error('Error fetching user:', error);
            }
        };

        fetchUser();
    }, [userID]);

    const handleDelete = async () => {
        try {
            await UserService.deleteUser(userID);
            navigate('/users');
        } catch (error) {
            console.error('Error deleting user:', error);
        }
    };
    return (
        <>
            <Table striped bordered hover>
                <tbody>
                <tr>
                    <td>Id</td>
                    <td>{user?.id}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>{user?.name}</td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td>{user?.dob}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>{user?.email}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>{user?.address}</td>
                </tr>
                <tr>
                    <td>Phone number</td>
                    <td>{user?.phone_number}</td>
                </tr>
                </tbody>
            </Table>
            <Button  variant="danger" onClick={handleDelete}>
                DELETE USER
            </Button>
        </>
    )

}


export default UserPage;