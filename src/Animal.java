/**
 * Animal class for initialize animals
 * @author Artem Getman
 * @date 15.07.2015
 */
public class Animal implements Pet {

    /**
     * @param name Name of the animal
     */
    private String name;

    /**
     * Constructor for initialize an animal
     * @param name Name of the animal
     */
    public Animal(String name){
        this.name = name;
    }

    /**
     * Returns name of the animal
     * @return name of the animal
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets name for the animal
     * @param name Name for the animal
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
