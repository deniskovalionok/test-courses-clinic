import java.util.Scanner;

/**
 * ClientRunner class for connect user and program,
 * to input new clients and to use all of clinic functions.
 * @author Artem Getman
 * @date 16.07.2015
 */
public class ClientRunner {

    private static String SHOW_CLIENT_LIST = "Show client list";
    private static String ADD = "Add new client";
    private static String FIND_ClIENT = "Find client";
    private static String FIND_PET = "Find pet";
    private static String CHANGE_CLIENT_NAME = "Change client's name";
    private static String CHANGE_PET_NAME = "Change pet's name";
    private static String DELETE_CLIENT = "Delete client";
    private static String DELETE_PET = "Delete pet";
    private static String EXIT = "Exit";
    private static String slash = "-------------------";
    private static Scanner in;
    private static Clinic clinic;

    public static void main(String[] args){
        in = new Scanner(System.in);
        clinic = new Clinic();
        clinic.addClient("Peter", new Dog("Rex"));
        clinic.addClient("Bob", new Dog("Pex"));
        clinic.addClient("Marley", new Dog("Fex"));
        clinic.addClient("Jimmy", new Cat("Felix"));
        clinic.addClient("Hendrix", new Snake("Marvin"));
        start();

    }

    /**
     * Method for checking correctness of input numbers to switch
     * different points of menu
     * @param selection - number that is printed from keyboard
     * @param a - lower edge
     * @param b - upper edge
     * @return
     */
    public static int check(int selection, int a, int b){
        while (selection < a || selection > b){
            System.out.println("You entered wrong number. Please try again");
            selection = in.nextInt();
        }
        return selection;
    }

    /**
     * Method that makes user to choose to keep working in program or exit
     */
    public static void nextOperation(){
        System.out.println("Do you want to select new operation? y/n");
        String selection = in.next();
        while(!selection.equalsIgnoreCase("y")  && !selection.equalsIgnoreCase("n")){
            System.out.println("You entered wrong letter. Please try again");
            selection = in.next();
        }
        switch (selection){
            case "Y":
            case "y":
                start();
                break;
            case "N":
            case "n":
                exit();
                break;
        }
    }

    /**
     * Start of the ClientRunner program
     * Entering main menu
     */
    private static void start(){
        System.out.println("--- Welcome to our Clinic ---");
        System.out.println("Choose next actions:");
        System.out.println(String.format("1) %s \n2) %s \n3) %s \n" +
                        "4) %s \n5) %s \n6) %s \n7) %s \n8) %s \n9) %s", SHOW_CLIENT_LIST, ADD,
                FIND_ClIENT, FIND_PET, CHANGE_CLIENT_NAME, CHANGE_PET_NAME, DELETE_CLIENT, DELETE_PET, EXIT));
        int selection = in.nextInt();
        selection = check(selection, 1, 9);
        switch (selection){
            case 1:
                showClientList();
                break;
            case 2:
                addClient();
                break;
            case 3:
                findClient();
                break;
            case 4:
                findPet();
                break;
            case 5:
                changeClientName();
                break;
            case 6:
                changePetName();
                break;
            case 7:
                removeClient();
                break;
            case 8:
                removePet();
                break;
            case 9:
                exit();
                break;
        }
        System.out.println(slash);
    }

    /**
     * Shows list of clients
     */
    private static void showClientList(){
        System.out.println("--- Client list ---");
        clinic.showClients();
        System.out.println(slash);
        nextOperation();
    }

    /**
     * Add new client
     */
    private static void addClient(){
        System.out.println("Enter new client's name: ");
        String clientName = in.next();
        System.out.println(String.format("Enter %s 's pet's name: ", clientName));
        String petName = in.next();
        System.out.println("Choose type of pet: \n 1) Dog \n 2) Cat \n 3) Snake");
        int selection = in.nextInt();
        selection = check(selection, 1, 3);
        Pet pet = null;
        switch (selection){
            case 1:
                pet = new Dog(petName);
                break;
            case 2:
                pet = new Cat(petName);
                break;
            case 3:
                pet = new Snake(petName);
                break;
        }
        clinic.addClient(clientName, pet);
        System.out.println(String.format("Client %s added to the list", clientName));
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To find client
     */
    private static void findClient(){
        System.out.println("Find client:\n1) by Name \n2) by Pet's name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection){
            case 1:
                System.out.println("Enter client's name: ");
                String clientName = in.next();
                clinic.findClient(clientName).toString();
                break;
            case 2:
                System.out.println("Enter pet's name: ");
                String petName = in.next();
                clinic.findClientByPetsName(petName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To find pet
     */
    public static void findPet(){
        System.out.println("Find pet:\n1) by Name \n2) by Client's name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection){
            case 1:
                System.out.println("Enter pet's name: ");
                String petName = in.next();
                clinic.findPet(petName).toString();
                break;
            case 2:
                System.out.println("Enter client's name: ");
                String clientName = in.next();
                clinic.findPetByClientName(clientName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To change client's name
     */
    public static void changeClientName(){
        System.out.println("Change client's name:\n1) by id \n2) by previous name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        String newName = null;
        switch (selection){
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                System.out.println("Enter new name: ");
                newName = in.next();
                clinic.changeClientsNameById(id, newName);
                break;
            case 2:
                System.out.println("Enter previous client's name: ");
                String clientName = in.next();
                System.out.println("Enter new client's name: ");
                newName = in.next();
                clinic.changeClientsName(clientName, newName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To change pet's name
     */
    public static void changePetName(){
        System.out.println("Change pet's name:\n1) by id \n2) by previous name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        String newName = null;
        switch (selection){
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                System.out.println("Enter new name: ");
                newName = in.next();
                clinic.changePetsNameById(id, newName);
                break;
            case 2:
                System.out.println("Enter previous pet's name: ");
                String clientName = in.next();
                System.out.println("Enter new pet's name: ");
                newName = in.next();
                clinic.changePetsName(clientName, newName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To remove client
     */
    public static void removeClient(){
        System.out.println("Remove client:\n1) by id \n2) by name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection){
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                clinic.removeClientById(id);
                break;
            case 2:
                System.out.println("Enter client's name: ");
                String clientName = in.next();
                clinic.removeClientByName(clientName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * To remove pet
     */
    public static void removePet(){
        System.out.println("Remove pet:\n1) by id \n2) by name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection){
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                clinic.removePetById(id);
                break;
            case 2:
                System.out.println("Enter pet's name: ");
                String petName = in.next();
                clinic.removePetByName(petName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    /**
     * Exit from program
     */
    public static void exit(){
        System.out.println("Do you really want to exit? y/n");
        String selection = in.next();
        while(!selection.equalsIgnoreCase("y")  && !selection.equalsIgnoreCase("n")){
            System.out.println("You entered wrong letter. Please try again");
            selection = in.next();
        }
        switch (selection){
            case "Y":
            case "y":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case "N":
            case "n":
                nextOperation();
                break;
        }
    }
}
