import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class ToDoApp extends Main {

  public ToDoApp() {
  }

  public void writeOut(LinkedHashMap toDoMap) {
    if (toDoMap.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      Set set = toDoMap.entrySet();
      Iterator iterator = set.iterator();
      for (int i = 0; i < toDoMap.size(); i++) {
        Map.Entry linked = (Map.Entry) iterator.next();
        if (linked.getValue().equals(true)) {
          System.out.println(i+1 + " - [x] " + linked.getKey());
        } else {
          System.out.println(i+1 + " - [ ] " + linked.getKey());
        }
      }
    }
  }

  public void reWriteList(LinkedHashMap toDoMap, String FILE_NAME) {
    List<String> result = new ArrayList<>();
    Set set = toDoMap.entrySet();
    Iterator iterator = set.iterator();
    for (int i = 0; i < toDoMap.size(); i++) {
      Map.Entry linked = (Map.Entry) iterator.next();
      if (linked.getValue().toString().equals("true")) {
        result.add(linked.getKey() + ";done" + "\n");
      } else {
        result.add(linked.getKey() + ";undone" + "\n");
      }
    }
    try {
      Writer output;
      output = new BufferedWriter(new FileWriter(FILE_NAME));
      for (String i : result) {
        output.write(String.valueOf(i));
      }
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("ToDo list is updated!");
  }

  public void addNewTask(LinkedHashMap toDoMap, String[] args) {
    toDoMap.put(args[2], false);
  }

  public String toFile(String[] args) {
    String listResult = " ";
    listResult = (args[1].toString().concat(";undone"));
    return listResult;
  }

  public void addToFile(String listResult, String FILE_NAME) {
    try {
      Writer output;
      output = new BufferedWriter(new FileWriter(FILE_NAME, true));
      output.append("\n" + listResult);
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("New ToDo task added to list!");
  }

  public void removeTask(LinkedHashMap toDoMap, String[] args) {
    if (toDoMap.size() < 3) {
      System.out.println("Unable to remove: too few tasks");
    } else {
      toDoMap.remove(toDoMap.keySet().toArray()[Integer.parseInt(args[1]) - 1].toString());
      System.out.println("ToDo task removed!");
    }
  }

  public void checkTask(LinkedHashMap toDoMap, String[] args) {
    if (toDoMap.size() < 3) {
      System.out.println("Unable to check: too few tasks");
    } else if (toDoMap.values().toArray()[Integer.parseInt(args[1]) - 1].equals(false)) {
      System.out.println(toDoMap.values().toArray()[Integer.parseInt(args[1]) - 1]);
      toDoMap.put(toDoMap.keySet().toArray()[Integer.parseInt(args[1]) - 1], true);
      System.out.println("ToDo task checked!");
      System.out.println(toDoMap);
    }
    else {
      System.out.println("The task is already done!");
    }
  }
}