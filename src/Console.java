import java.util.Scanner;

public class Console {
    ToyInteractions ti;
    Console(){
        ti = new ToyInteractions();
        printInstructions();
    }

    boolean userCommand(){
        String command = getData();
        try{
            switch (Integer.parseInt(command)) {
                //add toy
                case 1 -> {
                    ti.addToy();
                }
                //print all toys
                case 2 -> {
                    ti.printAll();
                }
                //change chance
                case 3 -> {
                    try{
                        print("Type index: ");
                        int index = Integer.parseInt(getData());
                        print("Type chance");
                        double chance = Double.parseDouble(getData());
                        ti.changeChance(index, chance);
                    }
                    catch (NumberFormatException ex){
                        print("Invalid input");
                    }
                }
                //save file
                case 4 -> {
                    ti.saveFile();
                }
            }
            printLn("---------------------");
            return true;
        }
        catch (NumberFormatException ex){
            if (command.equals("exit")){
                print("Bye");
                return false;
            }
            else {
                printLn("invalid input");
                printLn("---------------------");
                return true;
            }

        }
    }
    void printInstructions(){
        print("Type 1 for add toy\r\nType 2 for see all toys\r\nType 3 for change chance\r\nType 4 for save file\r\nCommand: ");
    }
    public static void print(String data){
        System.out.print(data);
    }
    public static void printLn(String data){
        System.out.println(data);
    }

    public static String getData(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
