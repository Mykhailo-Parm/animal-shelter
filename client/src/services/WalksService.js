import api from '../utils/api';

const WalksService =  {
    getAllBookedWalks: async () => {
        try {
            const response = await api.get('/bookedWalks');
            return response.data;
        } catch (error) {
            throw new Error('Error fetching booked walks: ' + error);
        }
    },
    createBookedWalk: async (walksData) => {
        try {
            const response = await api.post('/bookedWalks', walksData);
            return response.data;
        } catch (error) {
            console.error('Error creating booked walk: ', error);
            throw new Error('Error creating user: ' + error);
        }
    },
    deleteBookedWalk: async (userID, animalID) => {
        try{
            const response = await api.delete('/bookedWalks/'+userID+'/'+animalID);
            return response.data;
        } catch (error) {
            throw new Error('Error deleting booked walk: ' + error);
        }
    }
}

export default WalksService;