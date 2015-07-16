/**
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Snake implements Pet {

    private Animal animal;
    private String petType = "Snake";

    public Snake(Animal animal){
        this.animal = animal;
    }

    public Snake(String name){
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
        System.out.println(String.format("%s says: %s", this.getName(), "SSS-SSS-SSS"));
    }

    @Override
    public String getPetType() {
        return "Snake";
    }

    @Override
    public void setPetType(String type) {
        this.petType = type;
    }
}
