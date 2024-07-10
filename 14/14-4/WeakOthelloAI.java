import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeakOthelloAI implements OthelloAI {
  public int[] decide(int[][] board) {
    List<int[]> possibleMoves = new ArrayList<>();
    
    // 全ての打てる場所を洗い出す
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if (board[x][y] == 0) {
          possibleMoves.add(new int[]{x, y});
        }
      }
    }
    
    // ランダムに選ぶ
    if (possibleMoves.isEmpty()) {
      return null; // もし打てる場所がなければnullを返す
    }
    
    Random rand = new Random();
    return possibleMoves.get(rand.nextInt(possibleMoves.size()));
  }
}
