/**
 * Pet interface
 * @author Artem Getman
 * @date 15.07.2015
 */
public interface Pet {
    String getName();
    default void setName(String name){}
    default void getVoice(){}
    default String getPetType(){
        return null;
    }
    default void setPetType(String type){}

}
