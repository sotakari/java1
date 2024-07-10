import java.util.Scanner;

public class OthelloGame {
  public static void main(String[] args) {
    System.out.println("オセロゲームを開始します");
    int[][] board = new int[8][8];

    OthelloAI ai = null;
    Scanner scanner = new Scanner(System.in);
    System.out.println("コンピュータの強さを選んでください (1=弱い, 2=強い, 3=その他)");
    int cpuno = scanner.nextInt();
    scanner.nextLine();
    if (cpuno == 1) {
      ai = new WeakOthelloAI();
    } else if (cpuno == 2) {
      ai = new StrongOthelloAI();
    } else {
      System.out.println("人工知能クラスのFQCNを入力してください");
      String fqcn = scanner.nextLine();
      try {
        Class<?> clazz = Class.forName(fqcn);
        ai = (OthelloAI) clazz.getDeclaredConstructor().newInstance();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("無効なクラス名です。プログラムを終了します。");
        return;
      }
    }

    while (true) {
      printBoard(board);

      // プレイヤーの手を処理
      System.out.println("あなたの番: x座標とy座標をスペースで区切って入力してください");
      int playerX = scanner.nextInt();
      int playerY = scanner.nextInt();
      if (isValidMove(board, playerX, playerY)) {
        board[playerX][playerY] = 1; // 1をプレイヤーの石に対応させる
      } else {
        System.out.println("無効な手です。もう一度入力してください。");
        continue;
      }

      printBoard(board);

      // コンピュータの手を処理
      System.out.println("わたしの番：打つ場所を決めます");
      int[] nextStone = ai.decide(board);
      if (nextStone != null && isValidMove(board, nextStone[0], nextStone[1])) {
        board[nextStone[0]][nextStone[1]] = -1; // -1をコンピュータの石に対応させる
      } else {
        System.out.println("コンピュータの手が無効です。ゲームを終了します。");
        break;
      }
    }

    scanner.close();
  }

  private static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }

  private static boolean isValidMove(int[][] board, int x, int y) {
    return x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 0;
  }
}
