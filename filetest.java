import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;


public class filetest {
    public static void main(String[] args) {
        String fileName = "data.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                    stream.forEach(System.out::println);
        } catch(Exception e) { 
            e.printStackTrace();
        }
    }


}
