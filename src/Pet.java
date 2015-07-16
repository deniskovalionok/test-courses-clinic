/**
 * Pet interface
 * @author Artem Getman
 * @date 15.07.2015
 */
public interface Pet {
    /**
     * Returns name of the pet
     * @return name of the pet
     */
    String getName();
    /**
     * Set name for the pet
     * @param name Name for the pet
     */
    default void setName(String name){}
    /**
     * Get an individual voice of the pet
     */
    default void getVoice(){}
    /**
     * Get a type of the pet
     * @return Type of the pet
     */
    default String getPetType(){
        return null;
    }
    /**
     * Set type of the pet
     * Uses for "deleting" pet
     * @param type Type of the pet
     */
    default void setPetType(String type){}

}
