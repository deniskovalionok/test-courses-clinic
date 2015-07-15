/**
 * @author Artem Getman
 * @date 16.07.2015
 */
public class ClientRunner {

    public static void main(String[] args){
        Clinic clinic = new Clinic();
        clinic.addClient("Peter", new Dog("Rex"));
        clinic.addClient("Bob", new Dog("Pex"));
        clinic.addClient("Marley", new Dog("Fex"));
        clinic.addClient("Jimmy", new Cat("Felix"));
        clinic.addClient("Hendrix", new Snake("Marvin"));
        clinic.showClients();

    }
}
