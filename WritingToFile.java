import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToyToQueue(1, "Плюшевый мишка", 2);
        toyStore.addToyToQueue(2, "Машинка", 2);
        toyStore.addToyToQueue(3, "Кукла", 6);

        try (FileWriter writer = new FileWriter("toysList.txt")) {
            for (int i = 0; i < 10; i++) {
                int toyId = toyStore.getToy();
                writer.write(String.valueOf(toyId));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
