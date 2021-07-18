package models;

public class Breed {
    public String queryBreeds() {
        return "{ breeds { id name } }";
    }

    public String createBreedMutation(String breedName) {
        return String.format("mutation { createBreed ( input: { name: \"%s\" }) { id name } }", breedName);
    }
}
