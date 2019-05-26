package com.davegreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);                    // Here we create a scanner object to get input from the user in the console window.
    private static GroceryList groceryList = new GroceryList();                 // Here we create our groceryList object.

    public static void main(String[] args)
    {
        boolean quit = false;
        int choice = 0;

        printInstructions();

        while(!quit)                                                            // This states that as long as the opposite of whatever quit is set to is NOT TRUE then run the code block.
        {                                                                       // It could be argued that it would be just as easy and less confusing to say that while(quit == false).
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)                                                      // Depending on the user input the switch statement check each and executes the appropriate code.
            {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }


    public static void printInstructions()                                                      // This obviously prints out the options for the user and advises on what each option does.
    {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addItem()
    {
        System.out.print("Please enter the grocery item: ");                                    // This as can be seen calls the groceryList object and runs the addGroceryItem method.
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem()                                                             // Here we make sure that after we have created our itemNum variable and then called it as the argument
    {                                                                                           // to pass we specify that the actual number we are referring to when wanting to modify is the element number
        System.out.print("Current item name: ");                                                // minus 1, other wise we could very well try and ask to modify item 3 thinking that would be element 3, but
        String itemName = scanner.nextLine();                                                   // remember that the program starts counting from zero so item 3 would actually be position element 4 and if we
        //scanner.nextLine();                                                                   // only have 3 items in our groceryList this would throw an error as by trying to modify item 3 we would essentially
        System.out.print("Enter your replacement item: ");                                      // be trying to access position element 4 in the array, which if only 3 items exist then element 4 would not exist either
        String newItem = scanner.nextLine();                                                    // thereby creating the error.
        groceryList.modifyGroceryItem(itemName, newItem);
    }

    public static void removeItem()                                                             // This is similar to the above method in that we need to take the element number we want and minus 1 from it
    {                                                                                           // to affect the actual item we want to remove.
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();                                                   // Again all these methods are creating the groceryList object and then calling the appropriate methods.
        //scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem()                                                          // This is a method to search for an item and printing out the results.
    {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();

        if(groceryList.onFile(searchItem))
        {
            System.out.println("Found " + searchItem + " in our grocery list");
        }
        else
        {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }

    public static void processArrayList()                                                   // This is a quick method for copying over all the contents of the array to a new array without the need of
    {                                                                                       // having to iterate through for loops etc.

        // Method 1.
        ArrayList<String> newArray = new ArrayList<String>();                               // This method creates a new arrayList object and populates it with the old array contents by using the getter.
        newArray.addAll(groceryList.getGroceryList());

        // Method 2.
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());  // This method sets the new arrayList and populates it with the old arrayList values right at the point where we
                                                                                            // create a new arrayList object
        // Method 3.
        String[] myArray = new String[groceryList.getGroceryList().size()];                 // This method creates a String array (NOT AN ARRAY LIST) it then sets it to the value of the getter of the array list
        myArray = groceryList.getGroceryList().toArray(myArray);                            // it then changes the String array back into an array list.
    }






























}
