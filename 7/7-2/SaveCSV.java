import java.io.*;

public class SaveCSV {
  public void saveHeroToFile(Hero h) throws IOException {
    Writer bw = new BufferedWriter(new FileWriter("rpgsave.dat"));
    bw.write(h.name);
    bw.write(",");
    bw.write(h.hp);
    bw.write(",");
    bw.write(h.mp);
    bw.flush();
    bw.close();
  }
}