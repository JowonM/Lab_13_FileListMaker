import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileListMaker {
    // A Static ArrayList to hold Data//
    static ArrayList<String> list = new ArrayList<>();
    static boolean saved = false;
    static String fName = " ";
    static Scanner in = new Scanner(System.in);

    //Start of helper methods used//
    //a boolean method to see if one would like to exit//
    private static Boolean exitLoop() {
        //Use of safeInput method//
        boolean exitLoop = SaferInputLol.getYNConfirm(in, "Are you sure? Y or N.");
        return exitLoop;
    }

    //A simple Static method to delete a determined value based off of its number in the list//
    private static void deleteElement() {
        Scanner sc = new Scanner(System.in);
        String message = "Enter item number to remove";
        if (list.isEmpty()) {
            System.out.println("         List is Empty         ");
            return;
        }
        //Use of SafeInput method//
        int index = SaferInputLol.getRangedInt(sc, message, 1, list.size());
        list.remove(index - 1);
    }

    //A simple Static method to add a determined value//
    private static void addElement() {
        Scanner sc = new Scanner(System.in);
        String item = SaferInputLol.getNonZeroLenString(sc, "Enter item to add");
        list.add(item);

    }

    //A static method to print an element in the list//
    private static void view() {
        if (list.isEmpty()) {
            System.out.println("This list is empty...");
        } else {
            System.out.println("This is your list:");
            numberedList();
        }
    }

    //a Static method that will print the updated list with numbering//
    private static void numberedList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static void save() {
        if (fName.isEmpty()) {
            Scanner sc = new Scanner(System.in);

        }
    }

    public static void clear(ArrayList arrList) {
        arrList.clear();
    }

    private static void open() {
        Scanner sc = new Scanner(System.in);
        if (saved) {
            System.out.print("Current list has unsaved changes. Do you want to save it first? (Y/N) ");
            String answer = sc.nextLine().toUpperCase();
            if (answer.equals("Y")) {
                save();
                //this is the reminder to save
            }
        }
        System.out.print("Enter filename to load: ");
        String filename = sc.nextLine();
        File file = new File(filename + ".txt");
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                list.clear();
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                fName = filename;
                saved = false;
                System.out.println("List loaded.");
                reader.close();
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found.");
            //error loading file
        }
    }


    //The main method used to make use of the methods//

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.print("Enter command (A, D, V, O, S, C, Q): ");
            // This is where the commands are being coded
            String input = user.nextLine().toUpperCase();
            switch (input) {
                case "A":
                    addElement();
                    break;
                case "D":
                    deleteElement();
                    break;
                case "V":
                    view();
                    break;
                case "O":
                    open();
                    break;
                case "S":
                    save();
                    break;
                case "C":
                    clear(list);
                    break;
                case "Q":
                    quit = exitLoop();
                    break;
                default:
                    System.out.println("Please enter a valid command");
            }
        }
    }
}
