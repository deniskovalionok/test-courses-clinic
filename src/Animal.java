/**
 * Created by Artem on 15.07.2015.
 */
public class Animal implements Pet {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
