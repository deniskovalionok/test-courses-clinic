/**
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Dog implements Pet {

    private String name;
    private Animal animal;

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
        this.name = name;
    }

    @Override
    public void getVoice() {
        System.out.println(String.format("% says: %", this.getName(), "GAV-GAV-GAV"));
    }

    @Override
    public String getPetType() {
        return "Dog";
    }
}
