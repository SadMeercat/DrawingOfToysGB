import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToyInteractions {
    Queue<Toy> toys;

    ToyInteractions(){
        this.toys = new PriorityQueue<>();
    }
    void addToy(){
        try{
            Console.print("Input id: ");
            int tmpId = Integer.parseInt(Console.getData());
            Console.print("Input name: ");
            String tmpName = Console.getData();
            Console.print("Input chance: ");
            double tmpChance = Double.parseDouble(Console.getData());
            Toy tmpToy = new Toy(tmpId, tmpName);
            tmpToy.setChance(tmpChance);
            this.toys.add(tmpToy);
        }
        catch (NumberFormatException ex){
            Console.printLn("Uncorrected input");
        }

    }

    Toy takeToy(int index){
        int size = toys.size();
        if (index < 0 || size < index + 1) {
            Console.printLn("NUll");
            return null;
        }

        Toy tmpToy = null;
        for (int i = 0; i < size; i++){
            if (i == index){
                tmpToy = toys.remove();
            }
            else{
                toys.add(toys.remove());
            }
        }
        return tmpToy;
    }
    void changeChance(int index, double chance){
        Toy savedToy = takeToy(index);
        savedToy.setChance(chance);
        toys.add(savedToy);
    }
    void saveFile(){
        Queue<Toy> tmp = new PriorityQueue<>(toys);
        try(FileWriter writer = new FileWriter("note.txt", false))
        {
            StringBuilder text = new StringBuilder();
            while(!tmp.isEmpty()){
                text.append(tmp.poll()).append("\r\n");
            }
            writer.write(text.toString());

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    void printAll(){
        Queue<Toy> tmp = new PriorityQueue<>(toys);

        while(!tmp.isEmpty()){
            Console.printLn(tmp.remove().toString());
        }
    }
}
