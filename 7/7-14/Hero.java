import java.io.*;

public class Hero implements Serializable {
  private String name;
  private int hp, mp;
  public Hero(String name, int hp, int mp) {
    this.name = name;
    this.hp = hp;
    this.mp = mp;
  }
}