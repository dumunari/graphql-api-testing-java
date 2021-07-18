package models;

public class Puppy {
    public String queryPuppies(){
        return "{ puppies { id name breed { name } parents { name breed { name } puppies { name } } } }";
    }

    public String createPuppiesMutation(String name, String color, String breedId, String firstParentId, String secondParentId ){
        return String.format("mutation { createPuppy(input: { name: \"%s\", color: \"%s\", breedId: \"%s\", parentsId: [\"%s\", \"%s\"] }) { id name color } }", name, color, breedId, firstParentId, secondParentId);
    }
}
