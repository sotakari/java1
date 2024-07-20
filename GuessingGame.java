import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess = 0;
        boolean win = false;

        System.out.println("1から100の間の数字を当ててください！");

        while (!win) {
            System.out.print("数字を入力: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("もっと大きい数字です。");
            } else if (guess > numberToGuess) {
                System.out.println("もっと小さい数字です。");
            } else {
                win = true;
                System.out.println("おめでとうございます！ 数字は " + numberToGuess + " でした。");
                System.out.println("試行回数: " + numberOfTries);
            }
        }

        scanner.close();
    }
}
