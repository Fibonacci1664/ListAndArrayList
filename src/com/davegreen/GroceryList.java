package com.davegreen;

import java.util.ArrayList;

/**
 * Created by daveg on 30/06/2017.
 */
public class GroceryList
{
    private ArrayList<String> groceryList = new ArrayList<String>();                            // Here we declare an ArrayList of type String, that's the part in the <> symbols, called groceryList.

    public void addGroceryItem(String item)
    {
        groceryList.add(item);                                                                  // Java has built in functions like .add so that we can add items to our groceryList with the
    }                                                                                           // argument that is passed when calling the method.

    public ArrayList<String> getGroceryList()
    {
        return groceryList;
    }

    public void printGroceryList()
    {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");   // Here we are printing out the amount of items in the groceryList, again using a built in function .size.
        for(int i = 0; i < groceryList.size(); i ++)                                            // We then enter into a for loop, and as it iterates each time printing out the next item from the element
        {                                                                                       // i in the list, this is shown by the sout statement within the for loop, we use i + 1 because remember arrays
            System.out.println((i + 1) + ", " + groceryList.get(i));                            // start counting from zero but we as humans we just call the first item we see as item one, so it prints soemthing like this:
        }                                                                                       // (element 0, this would not be printed) 1, retrieve the groceryList item at element position zero.
    }                                                                                           // (element 1, this would not be printed) 2, retrieve the groceryList item at element position one. and so on and so on.

    public void modifyGroceryItem(String currentItem, String newItem)
    {
        int position = findItem(currentItem);
        if(position >= 0)
        {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem)
    {
        groceryList.set(position, newItem);                                                     // Again using built in function .set we are able to take the arguments that are passed when calling the
        System.out.println("Grocery item " + (position + 1) + " has been modified.");           // modifyGroceryItem method and set the new item to a particular position in the array, in turn replacing
    }                                                                                           // the old item.

    private void removeGroceryItem(int position)                                                 // We are using two functions here the .get function and then later on the .remove function, the .get allows
    {                                                                                           // us to create a variable and set it to the value of the argument passed when calling the method, all that remains
        //String theItem = groceryList.get(position);
        groceryList.remove(position);                                                           // is to then use the .remove function using the variable "theItem" as its argument.
        //groceryList.remove(theItem);                                                          // As is above both methods have been set to private instead of public forcing the user to use only the methods we
    }                                                                                           // want them to use and not giving them access to choose element position but however still having that functionality
                                                                                                // built into the class private methods which the public methods call
    public void removeGroceryItem(String item)
    {
        int position = findItem(item);
        if(position >= 0)
        {
            removeGroceryItem(position);
        }
    }

    private int findItem(String searchItem)                                                      // Here we are once again using another built in function to search for an item in the groceryList, we can
    {                                                                                           // do it two ways, as you can see we have created a boolean called exists and then set that to the groceryList
        return groceryList.indexOf(searchItem);                                                 // function .contains with the argument passed from the method call as it own argument, the .contains function
        //boolean exists = groceryList.contains(searchItem);                                    // returns the index of the FIRST occurrence of the specified element in this list, or -1 if this list does not
                                                                                                // contain the element. The .indexOf function returns the index of the LAST occurrence of the specified element in
        //int position = groceryList.indexOf(searchItem);                                       // this list, or -1 if this list does not contain the element.
                                                                                                // We then create a small conditional check to say that if the index that is returned from the search and which is that that
        //if(position >= 0)                                                                       // is stored in the variable position is >= 0, in other words the search has found something matching, then return this items index to
        //{                                                                                       // wherever it was called from, otherwise return null(in other words the search did not find anything matching, thereby returning
            //return groceryList.get(position);                                                   // -1 as its result and as -1 is < 0 the if statements condition return false never executing the code block and skipping to the
        //}                                                                                       // return null statement.

        //return null;                                                                            // After starting lecture 58, we were shown a new way to return an item in the groceryList which would work in conjunction
    }                                                                                             // with the new modifyGroceryItem method that has only 1 parameter.
                                                                                                  // The return type was changed from String to int and all code commented out and the new line added at the start.

    public boolean onFile(String searchItem)
    {
        int position = findItem(searchItem);

        if(position >= 0)
        {
            return true;
        }

        return false;
    }
}
