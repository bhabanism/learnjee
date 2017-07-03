import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {
    public static Stream readFile(String filename) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream;
        } catch(Exception e) {
            throw e;
        }
    }
}
