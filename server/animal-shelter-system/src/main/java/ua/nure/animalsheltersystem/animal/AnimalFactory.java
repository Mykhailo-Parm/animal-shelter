package ua.nure.animalsheltersystem.animal;

public class AnimalFactory {
    Animal createAnimal(Animal animal) {
        if (animal.getBreed() == "Husky") {
            return new Husky(animal);
        } else if (animal.getBreed() == "Persian") {
            return new Persian(animal);
        } else {
            return animal;
        }
    }
}
