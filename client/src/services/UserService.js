import api from '../utils/api';
import WalksService from "./WalksService";

const UserService = {
    getAllUsers: async () => {
        try {
            const response = await api.get('/users');
            return response.data;
        } catch (error) {
            throw new Error('Error fetching users: ' + error);
        }
    },
    getUser: async (id) => {
        try {
            const response = await api.get("/users/"+id);
            return response.data;
        } catch (error) {
            throw new Error('Error fetching user: ' + error);
        }
    },
    createUser: async (userData) => {
        try {
            const response = await api.post('/users', userData);
            return response.data;
        } catch (error) {
            console.error('Error creating user:', error);
            throw new Error('Error creating user: ' + error);
        }
    },
    deleteUser: async (id) => {
        try{
            const response1 = WalksService.deleteBookedWalk(id, 0);
            const response2 = await api.delete('/users/'+id);
            return response2.data;
        } catch (error) {
            throw new Error('Error deleting user: ' + error);
        }
    }
};

export default UserService;