import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        final String menu = "A - Add D - Delete P - Print Q - Quit";
        String menuChoice = "";
        boolean done = false;

        do{
            displayList(); // display the list
            menuChoice = SafeInput.getRegExString(in, "Enter a menu choice: " + menu, "[AaDdPpQq]"); // call SafeInput method and prompts user to enter a menu choice Aa, Dd, Pp, or Qq
            menuChoice = menuChoice.toUpperCase(); // translates input into upper case
            switch(menuChoice) // switch selector based on which menu option was entered
            {
                case "A":
                    String listItem = SafeInput.getNonZeroLenString(in, "What would you like to add to the list?: "); // prompt user for a list item + make sure it's not an empty string
                    list.add(listItem); // add item to list
                    break;

                case "D":
                    int delete = SafeInput.getRangedInt(in, "What item would you like to remove? ", 1, list.size()); // prompt user for number of item to delete
                    delete = delete - 1; // translate number to an index by subtracting by 1
                    list.remove(delete);  // remove item from list
                    break;

                case "P":
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // header to go above list
                    if(list.size() != 0) // if list is not empty
                    {
                        for (int x = 0; x < list.size(); x++)
                        {
                            System.out.println(list.get(x)); // print each element in array list
                        }
                    }
                    else
                    {
                        System.out.println("~~~             List is empty             ~~~"); // output to tell user list is empty
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // footer under list
                    break;

                case "Q":
                    boolean confirm = SafeInput.getYNConfirm(in, "Are you sure you want to quit?"); // prompt to ask user if they are sure if they want to quit
                    if (confirm) // if user says they do want to quit
                    {
                        System.out.println("Goodbye!"); // output
                        done = true;
                        System.exit(0); // exits program
                    }
                    break;
            }

        }while(!done); // menu will continue to loop and prompt user until they quit

    }

    private static void displayList()
    {
        System.out.println("*********************************************"); // header
        if(list.size() != 0) // if list is not empty
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-3d%-35s\n", i + 1, list.get(i)); // prints a numbered list
            }
        }
        else // list is empty
        {
            System.out.println("***             List is empty             ***"); // output to tell user list is empty
        }
        System.out.println("*********************************************"); // footer

    }
}
