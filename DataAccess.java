import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataAccess {
    private static final String DATA_SOURCE = "data.csv";
    
    public static List<String> getData() throws Exception {
        return readFile(DATA_SOURCE);        
    }

    private static List<String> readFile(String filename) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            List<String> list = new ArrayList<String>();
            stream.forEach(line -> list.add(line));
            return list;
        } catch(Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            List<String> list = getData();
            for(String line : list) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
