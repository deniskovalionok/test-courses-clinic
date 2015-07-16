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

    public Client findClient(String clientName){
        Client client;
        System.out.println(String.format("Trying to find client %s ...", clientName));
        int i=0;
        while (!clientList.get(i).getName().equalsIgnoreCase(clientName)
                && i < clientList.size()-1){
            i++;
        }
        if(clientList.get(i).getName().equalsIgnoreCase(clientName)){
            System.out.println(String.format("Found >> id: %s; name: %s; pet: %s", clientList.get(i).getId(),
                    clientList.get(i).getName(), clientList.get(i).getPet().getName()));
            client = clientList.get(i);
        } else {
            System.out.println(String.format("Can't find client with name %s !", clientName));
            client = null;
        }
        return client;
    }

    public Pet findPet(String petName){
        Pet pet;
        System.out.println(String.format("Trying to find pet %s ...", petName));
        int i=0;
        while (!clientList.get(i).getPet().getName().equalsIgnoreCase(petName)
                && i < clientList.size()-1){
            i++;
        }
        if(clientList.get(i).getPet().getName().equalsIgnoreCase(petName)){
            System.out.println(String.format("Found >> id: %s; pet: %s; owner: %s", clientList.get(i).getId(),
                    clientList.get(i).getPet().getName(), clientList.get(i).getName()));
            pet = clientList.get(i).getPet();
        } else {
            System.out.println(String.format("Can't find pet with name %s !", petName));
            pet = null;
        }
        return pet;
    }

    public void findPetByClientName(String clientName){
        System.out.println(String.format("Trying to find %s pet...", clientName));
        int i=0;
        while (!clientList.get(i).getName().equalsIgnoreCase(clientName)
                && i < clientList.size()-1){
            i++;
        }
        if(clientList.get(i).getName().equalsIgnoreCase(clientName)){
            System.out.println(String.format("Found >> id: %s; name: %s", clientList.get(i).getId(),
                    clientList.get(i).getPet().getName()));
        } else {
            System.out.println(String.format("Can't find %s pet!", clientName));
        }
    }

    public void findClientByPetsName(String petName){
        System.out.println(String.format("Trying to find %s owner...", petName));
        int i=0;
        while (!clientList.get(i).getPet().getName().equalsIgnoreCase(petName)
                && i < clientList.size()-1){
            i++;
        }
        if(clientList.get(i).getPet().getName().equalsIgnoreCase(petName)){
            System.out.println(String.format("Found >> id: %s; name: %s", clientList.get(i).getId(),
                    clientList.get(i).getName()));
        } else {
            System.out.println(String.format("Can't find %s owner!", petName));
        }
    }

    public void changePetsNameById(int id, String newName){
        clientList.get(id-1).getPet().setName(newName);
    }

    public void changeClientsNameById(int id, String newName){
        clientList.get(id - 1).setName(newName);
    }

    public void changeClientsName(String oldName, String newName){
        Client client = findClient(oldName);
        client.setName(newName);
        System.out.println(String.format("Changed client's %s name to %s", oldName,
                client.getName()));
    }

    public void changePetsName(String oldName, String newName){
        Pet pet = findPet(oldName);
        pet.setName(newName);
        System.out.println(String.format("Changed pet's %s name to %s", oldName,
                pet.getName()));
    }

    public void removeClientById(int id){
        clientList.remove(id - 1);
        System.out.println(String.format("Client with id: %d was deleted!", id));
    }

    public void removePetById(int id){
        System.out.println(String.format("Client's %s pet %s was deleted!",
                clientList.get(id - 1).getName(), clientList.get(id - 1).getPet().getName()));
        clientList.get(id-1).deletePet();
    }

    public void removeClientByName(String clientName){
        Client client = findClient(clientName);
        clientList.remove(client.getId() - 1);
        System.out.println(String.format("Client %s has been deleted!", client.getName()));
    }

    public void removePetByName(String petName){
        Pet pet = findPet(petName);
        System.out.println(String.format("Pet %s was deleted!", pet.getName()));
        pet.setName("NO PETS");
        pet.setPetType("none");
    }
}
