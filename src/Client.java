/**
 * Client class to initialize client
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Client {


    private String name; // name of the client
    private int id; // id of the client
    private Pet pet; // pet of the client

    /**
     * Constructor for Client class
     * @param id id of the client
     * @param name name of the client
     * @param pet pet of the client
     */
    public Client(int id,String name, Pet pet){
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    /**
     * returns client's name
     * @return name of the client
     */
    public String getName() {
        return this.name;
    }

    /**
     * sets name of the client
     * @param name of the client
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns id of the client
     * @return id of the client
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns pet of the client
     * @return pet of the client
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Method for deleting pet of the client
     */
    public void deletePet(){
        this.pet.setPetType("none");
        this.pet.setName("NO PETS");
    }

    /**
     * Returns parameters of the client in String
     * @return parameters of the client
     */
    public String toString(){
        return String.format("Client's id: %s; name: %s; pet: %s; pet's type: %s", getId(),
                getName(), getPet().getName(), this.pet.getPetType());
    }
}
