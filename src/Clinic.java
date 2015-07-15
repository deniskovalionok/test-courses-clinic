import java.util.ArrayList;

/**
 * Clinic class to store information about Clients and their Pets
 * @author Artem Getman
 * @date 16.07.2015
 */
public class Clinic {

    private ArrayList<Client> clientList;
    private int id = 1;

    public Clinic(){
        clientList = new ArrayList<>();
    }

    public void addClient(String name, Pet pet){

        clientList.add(new Client(id++, name, pet));
    }

    public void showClients(){
        for(int i=0; i < clientList.size(); i++){
            System.out.println(clientList.get(i).toString());
        }

    }

}
