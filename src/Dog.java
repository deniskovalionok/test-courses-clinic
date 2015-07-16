/**
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Dog implements Pet {

    private Animal animal;
    private String petType = "Dog";

    public Dog(Animal animal){
        this.animal = animal;
    }

    public Dog(String name){
        this(new Animal(name));
    }

    @Override
    public String getName() {
        return this.animal.getName();
    }

    @Override
    public void setName(String name) {
        this.animal.setName(name);
    }

    @Override
    public void getVoice() {
        System.out.println(String.format("%s says: %s", this.getName(), "GAV-GAV-GAV"));
    }

    @Override
    public String getPetType() {
        return petType;
    }

    @Override
    public void setPetType(String type) {
        this.petType = type;
    }
}
