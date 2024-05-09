import java.io.*;

public class Test {
  public static void main(String[] args) throws IOException {
    String msg = "第1土曜日は資源ゴミの回収です。";
    Reader sr = new StringReader(msg);
    int character;
    while ((character = sr.read()) != -1) {  // 文字が終わるまで繰り返し
        System.out.print((char)character);
    }
    System.out.println("\nファイルの末尾に到達しました");  // 終了を明示
    sr.close();  // リソースの解放
  }
}