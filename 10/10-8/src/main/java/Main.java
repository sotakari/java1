import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Main {
  public static void main(String[] args) {
    System.out.println("スッキリ魔王征伐 ver1.0.0 by minato");
    System.out.println("Mavenで鋭意開発中！待て次号！");
    try (Writer writer = new FileWriter("rpgdata.csv")) {
      CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
      String[] data = {"sukkiri-quest", "1.0.0"};
      csvWriter.writeNext(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}