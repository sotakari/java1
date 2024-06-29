public class Account {
  String owner;
  public Account(String owner, int zandaka) {
    this.owner = owner;
    this.zandaka = zandaka;
  }
  int zandaka;
  public void transfer(Account dest, int amount) {
    dest.zandaka += amount;
    zandaka -= amount;
    assert this.zandaka >= 0;
  }
}
