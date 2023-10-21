import java.util.PriorityQueue;
import java.util.Random;

class Toy {
    int id;
    String name;
    int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }
}

public class ToyStore {
    private PriorityQueue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>((t1, t2) -> t2.frequency - t1.frequency);
    }

    public void addToyToQueue(int id, String name, int frequency) {
        Toy toy = new Toy(id, name, frequency);
        toyQueue.add(toy);
    }

    public int getToy() {
        Random random = new Random();
        int totalFrequency = toyQueue.stream().mapToInt(t -> t.frequency).sum();
        int randomValue = random.nextInt(totalFrequency);
        int currentFrequency = 0;
        for (Toy toy : toyQueue) {
            currentFrequency += toy.frequency;
            if (randomValue < currentFrequency) {
                return toy.id;
            }
        }
        return 0;
    }
}
