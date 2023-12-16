import api from '../utils/api';
import WalksService from "./WalksService";

const AnimalService = {
    getAllAnimals: async () => {
        try {
            const response = await api.get('/animals');
            return response.data;
        } catch (error) {
            throw new Error('Error fetching animals: ' + error);
        }
    },
    getAnimal: async (id) => {
        try {
            const response = await api.get("/animals/"+id);
            return response.data;
        } catch (error) {
            throw new Error('Error fetching animal: ' + error);
        }
    },
    createAnimal: async (animalData) => {
        try {
            console.log(animalData);
            const response = await api.post('/animals', animalData);
            return response.data;
        } catch (error) {
            console.error('Error creating animal:', error);
            throw new Error('Error creating animal: ' + error);
        }
    },
    deleteAnimal: async (id) => {
        try{
            const response1 = WalksService.deleteBookedWalk(0, id);
            const response2 = await api.delete('/animals/'+id);
            return response2.data;
        } catch (error) {
            throw new Error('Error deleting animal: ' + error);
        }
    }
};

export default AnimalService;