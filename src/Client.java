/**
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Client {

    private String name;
    private int id;
    private Pet pet;

    public Client(int id,String name, Pet pet){
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void deletePet(){
        this.pet.setPetType("none");
        this.pet.setName("NO PETS");
    }

    public String toString(){
        return String.format("Client's id: %s; name: %s; pet: %s; pet's type: %s", getId(),
                getName(), getPet().getName(), this.pet.getPetType());
    }
}
