import java.util.Comparator;

public class Toy implements Comparable<Toy> {
    int id;
    String name;
    double chance;

    Toy(int id, String name){
        this.id = id;
        this.name = name;
    }

    void setChance(double chance){
        if (chance>100){
            Console.printLn("Chance cant be higher 100. Default - 0");
        }
        else{
            this.chance = chance;
        }
    }

    @Override
    public int compareTo(Toy o) {
        return o.id < this.id ? 1 : -1;
    }

    @Override
    public String toString(){
        return "id: " + this.id + "; name: " + this.name + "; chance: " + this.chance;
    }
}
