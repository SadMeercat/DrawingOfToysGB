public class Main {
    public static void main(String[] args) {
        Console myConsole = new Console();
        while (myConsole.userCommand()){
            myConsole.printInstructions();
        }
    }
}