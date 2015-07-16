import java.util.Scanner;

/**
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

    public static int check(int selection, int a, int b){
        while (selection < a || selection > b){
            System.out.println("You entered wrong number. Please try again");
            selection = in.nextInt();
        }
        return selection;
    }

    private static void start(){
        System.out.println("--- Welcome to our Clinic ---");
        System.out.println("Choose next actions:");
        System.out.println(String.format("1) %s \n2) %s \n3) %s \n" +
                        "4) %s \n5) %s \n6) %s \n7) %s \n8) %s \n9) %s", SHOW_CLIENT_LIST, ADD,
                FIND_ClIENT, FIND_PET, CHANGE_CLIENT_NAME, CHANGE_PET_NAME, DELETE_CLIENT, DELETE_PET, EXIT));
        int selection = in.nextInt();
        selection = check(selection, 1, 9);
        System.out.println("selection: " + selection);
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
            case 9:
                exit();
                break;
        }
        System.out.println(slash);
    }

    private static void showClientList(){
        System.out.println("--- Client list ---");
        clinic.showClients();
        System.out.println(slash);
        start();
    }

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
        start();
    }

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
        start();
    }

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
                start();
                break;
        }
    }
}
