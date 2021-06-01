package cpsc2150.sets;

import java.util.*;

public class DoubleSetApp {

    private static final int EXIT_CHOICE = 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Print a menu of options
        printMenu();
        int input = Integer.parseInt(in.nextLine());
        while (input != EXIT_CHOICE) {
            if (input == 1) {
                //Make each set
                System.out.println("Make set 1");
                ISet<Double> set1 = getSet(in);
                System.out.println("Make set 2");
                ISet<Double>  set2 = getSet(in);

                //print the sets
                System.out.println("Set 1 is:");
                System.out.println(set1.toString());
                System.out.println("Set 2 is:");
                System.out.println(set2.toString());

                //union the sets together
                set1.union(set2);

                //print the union
                System.out.println("The union is:");
                System.out.println(set1.toString());
            } else {
                System.out.println("That was not an option");
            }

            //print the menu and get the next option
            printMenu();
            input = Integer.parseInt(in.nextLine());
        }
    }

    /**
     * This method will print the options menu
     *
     * @pre none
     * @post [menu will be displayed to user]
     */
    private static void printMenu() {
        System.out.println("\nMake a selection");
        System.out.println("1. Find the UNION of Two Sets");
        System.out.println(EXIT_CHOICE + ". Exit");
    }

    /**
     * This method will get the values from a user and build a set
     *
     * @param in a scanner object to use to get data from the user
     * @return a set that the user built
     * @pre in is open and connected to the user
     * @post getSet = [set containing the user provided values]
     */
    private static ISet<Double> getSet(Scanner in) {
        ISet<Double> s;
        //replace this so the user can choose between ListSet and ArraySet
        System.out.println("Select 1 for List implementation and 2 for Array implementation");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num == 1)
        {
            s = new ListSet<>();
        } else
        {
            s = new ArraySet<>();
        }



        // add values to the set until user enters "qt" to stop entering values
        System.out.println("Enter a value to add to the set. Enter qt to stop adding to the set");
        String val = in.nextLine();
        while (!val.equals("qt")) {
            //we can assume if they did not enter "qt", they did enter a number
            double addVal = Double.parseDouble(val);

            //add the value to our set
            if(s.getSize() >= ISet.MAX_SIZE)
            {
                //error handling
                System.out.println("Size must be less than" + ISet.MAX_SIZE + ".");
            }
            else if(s.contains(addVal))
            {
                //error handling
                System.out.println("Value has already been added.");
            } else
            {
                s.add(addVal);
            }

            //get the next value before looping
            System.out.println("Enter a value to add to the set. Enter qt to stop adding to the set");
            val = in.nextLine();
        }

        //we have filled our set, so we can return it
        return s;
    }
}