package models;

public class Dog {
    public String queryDogs() {
        return "{ dogs { id name age breed { name } puppies { name } } }";
    }

    public String createDogsMutation(String name, int age, String breedId) {
        return String.format("mutation { createDog(input: { name: \"%s\" age: %d, breedId: \"%s\" }) { name age } }", name, age, breedId);
    }

    public String addPuppyToParentsMutation(String puppyId, String firstParentId, String secondParentId) {
        return String.format("mutation { addPuppyToParents(input: { puppyId: \"%s\" " +
                "parentsId: [\"%s\", \"%s\"], }) { id name } }", puppyId, firstParentId, secondParentId);
    }
}
