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

    public int getId() {
        return this.id;
    }

    public Pet getPet() {
        return this.pet;
    }

    public String toString(){
        return "Client's id: " + getId() +
                "; name: " + getName() +
                "; pet: " + getPet().getName() +
                "; pet's type: " + this.pet.getPetType();
    }
}
