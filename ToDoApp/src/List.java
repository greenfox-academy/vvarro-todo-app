import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class List {

 public List() {
  }

  public static java.util.List<String> readListFromFile(String FILE_NAME) {
    Path path = Paths.get(FILE_NAME);
    java.util.List<String> list = null;

    try {
      list = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  Map<String, String> task = new HashMap<>();

  public Map processData(java.util.List<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String[] splittedLine = list.get(i).split(";");
      task.put(splittedLine[0], splittedLine[1]);
    }
    return task;
  }

}